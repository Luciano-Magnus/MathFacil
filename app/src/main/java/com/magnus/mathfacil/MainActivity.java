package com.magnus.mathfacil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> botoes = new ArrayList<>(Arrays.asList("Bhaskara", "Analise Combinatória", "Área"));
        ListView ListaDeBotoes = findViewById(R.id.activity_main_lista_de_botoes);
        ListaDeBotoes.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, botoes));
        ListaDeBotoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                String BotaoEscolhido = botoes.get(posicao);
                if(posicao==0) {
                    Intent vaiParaBhaskara = new Intent(MainActivity.this, Bhaskara.class);
                    startActivity(vaiParaBhaskara);
                }
                    if(posicao==1) {
                        Intent vaiParaAnaliseCombinatoria = new Intent(MainActivity.this, AnaliseCombinatoria.class);
                        startActivity(vaiParaAnaliseCombinatoria);
                    }
                if(posicao==2) {
                    Intent vaiParaArea = new Intent(MainActivity.this, Area.class);
                    startActivity(vaiParaArea);
                }

            }
        });
    }
}
