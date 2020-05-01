package com.magnus.mathfacil;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Circulo extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Círculo";
    EditText raio;
    float floatRaio, area;
    String stringRaio;
    Editable eRaio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        raio = findViewById(R.id.raio);
        final  Button calcular= findViewById(R.id.calcular_circulo);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(raio.getText().toString())) {
                    eRaio = raio.getText();
                    stringRaio = String.valueOf(eRaio);
                    floatRaio = Float.parseFloat(stringRaio);
                    area = (float) (floatRaio * floatRaio * 3.14);
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_circulo);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área= " + floatRaio + " * " + floatRaio + " * 3.14\nÁrea= " + res.format(floatRaio * floatRaio) + " * 3,14" + "\nÁrea= " + res.format(area));
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                }
                else{
                        AlertDialog.Builder alerta = new AlertDialog.Builder(Circulo.this);
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
