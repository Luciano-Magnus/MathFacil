package com.magnus.mathfacil;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Area extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Área";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        final List<String> acoes = new ArrayList<>(Arrays.asList("Círculo", "Quadrado", "Triângulo", "Losango", "Trapézio", "Retângulo", "Hexágono", "Cilindro", "Cubo"));
        ListView ListaDeAcoes = findViewById(R.id.activity_area_lista_de_acoes);
        ListaDeAcoes.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, acoes));
        ListaDeAcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                if (posicao == 0) {
                    Intent vaiParaCirculo = new Intent(Area.this, Circulo.class);
                    startActivity(vaiParaCirculo);
                }
                if (posicao==1){
                    Intent VaiParaQuadrado = new Intent(Area.this, Quadrado.class);
                    startActivity(VaiParaQuadrado);
                }
                if (posicao==2){
                    Intent VaiParaTriangulo = new Intent(Area.this, Triangulo.class);
                    startActivity(VaiParaTriangulo);
                }
                if (posicao==3){
                    Intent VaiParaLosango = new Intent(Area.this, Losango.class);
                    startActivity(VaiParaLosango);
                }
                if (posicao==4){
                    Intent VaiParaTrapezio = new Intent(Area.this, Trapezio.class);
                    startActivity(VaiParaTrapezio);
                }
                if (posicao==5){
                    Intent VaiParaRetangulo = new Intent(Area.this, Retangulo.class);
                    startActivity(VaiParaRetangulo);
                }
                if (posicao==6){
                    Intent VaiParaHexagono = new Intent(Area.this, Hexagono.class);
                    startActivity(VaiParaHexagono);
                }
                if (posicao==7){
                    Intent VaiParaCilindro = new Intent(Area.this, Cilindro.class);
                    startActivity(VaiParaCilindro);
                }
                if (posicao==8){
                    Intent VaiParaCubo = new Intent(Area.this, Cubo.class);
                    startActivity(VaiParaCubo);
                }
            }
        });
    }
}
