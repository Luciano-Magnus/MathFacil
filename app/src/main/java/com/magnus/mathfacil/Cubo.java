package com.magnus.mathfacil;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Cubo extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Cubo";
    private EditText aresta;
    private Editable eAresta;
    private String stringAresta;
    private Float floatAresta;
    private int i;
    Spinner d;
    String names[] = {"Área Total", "Área Lateral", "Área da base"};
    ArrayAdapter<String> arrayAdapter;
    private double area;
    double AB;
    double AL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));

        aresta = findViewById(R.id.aresta);
        Spinner d = findViewById(R.id.dropDown);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        d.setAdapter(arrayAdapter);
        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao == 0) {
                    i = 0;
                }
                if (posicao == 1) {
                    i = 1;
                }
                if (posicao == 2) {
                    i = 2;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });

        final Button calcular = findViewById(R.id.calcular_cubo);
        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!"".equals(aresta.getText().toString())) {
                    eAresta = aresta.getText();
                    stringAresta = String.valueOf(eAresta);
                    floatAresta = Float.parseFloat(stringAresta);
                    final TextView resultado = (TextView) findViewById(R.id.Resultado_cubo);
                    resultado.setTextColor(Color.BLACK);
                    DecimalFormat res = new DecimalFormat("0.00");
                    if (i == 0) {
                        resultado.setText("Área total= 6 * aresta²\nÁrea total= 6 * " + res.format(floatAresta) + "²" +
                                "\nÁrea total= 6 * " + res.format(floatAresta * floatAresta) + "\nÁrea total= " + res.format(6 * floatAresta * floatAresta));
                        area = 6 * floatAresta * floatAresta;
                    }
                    if (i == 1) {
                        resultado.setText("Área lateral= 4 * aresta²\nÁrea lateral= 4 * " + res.format(floatAresta) + "²" +
                                "\nÁrea lateral= 4 * " + res.format(floatAresta * floatAresta) + "\nÁrea lateral= " + res.format(4 * floatAresta * floatAresta));
                        area = 4 * floatAresta * floatAresta;
                    }
                    if (i == 2) {
                        resultado.setText("Área da base= aresta²\nÁrea da base= " + res.format(floatAresta) + "²" +
                                "\nÁrea da base= " + res.format(floatAresta * floatAresta));
                        area = floatAresta * floatAresta;
                    }

                } else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Cubo.this);
                    alerta.setTitle("Aviso");
                    alerta
                            .setIcon(R.drawable.ic_info)
                            .setMessage("Preencha todos os campos")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                }
            }
        });
    }
}
