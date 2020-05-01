package com.magnus.mathfacil;

import android.annotation.SuppressLint;
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

public class Hexagono extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Hexágono";
    EditText lado;
    float floatLado, area;
    String stringLado;
    Editable eLado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexagono);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        lado = findViewById(R.id.lado);
        final Button calcular = findViewById(R.id.calcular_hexagono);
        calcular.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!"".equals(lado.getText().toString())) {
                    eLado = lado.getText();
                    stringLado = String.valueOf(eLado);
                    floatLado = Float.parseFloat(stringLado);
                    area = floatLado * 6;
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.resultado_hexagono);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área= lado * 6 \n" +
                            "Área= " + res.format(floatLado) + " * 6,00\nÁrea= " + area);
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                } else {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Hexagono.this);
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