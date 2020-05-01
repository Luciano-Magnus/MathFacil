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

public class Quadrado extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Quadrado";
    EditText lado;
    Editable lado_quadrado;
    String stringLado;
    Float floatLado, area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        lado= findViewById(R.id.lado);
        final Button calcular= findViewById(R.id.calcular_quadrado);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(lado.getText().toString())) {
                    lado_quadrado = lado.getText();
                    stringLado = String.valueOf(lado_quadrado);
                    floatLado = Float.parseFloat(stringLado);
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_quadrado);
                    resultado.setTextColor(Color.BLACK);
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    resultado.setTextColor(Color.BLACK);
                    area = floatLado * floatLado;
                    resultado.setText(String.format("Área= l² \nÁrea= " + floatLado + "²\nÁrea= " + res.format(area)));
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                }
                     else{
                        AlertDialog.Builder alerta = new AlertDialog.Builder(Quadrado.this);
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
