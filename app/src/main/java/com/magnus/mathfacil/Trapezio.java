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

public class Trapezio extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Trapézio";
    EditText baseMaior, baseMenor, altura;
    Editable eBaseMaior, eBaseMenor, eAltura;
    String stringBaseMenor, stringBaseMaior, stringAltura;
    Float floatBaseMaior, floatBaseMenor, floatAltura, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapezio);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));

        baseMaior = findViewById(R.id.base_maior);
        baseMenor = findViewById(R.id.base_menor);
        altura = findViewById(R.id.altura);
        final Button calcular = findViewById(R.id.calcular_trapezio);
        calcular.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!"".equals(baseMaior.getText().toString()) && !"".equals(baseMenor.getText().toString()) && !"".equals(altura.getText().toString())) {
                    eBaseMaior = baseMaior.getText();
                    eBaseMenor = baseMenor.getText();
                    stringBaseMaior = String.valueOf(eBaseMaior);
                    stringBaseMenor = String.valueOf(eBaseMenor);
                    floatBaseMaior = Float.parseFloat(stringBaseMaior);
                    floatBaseMenor = Float.parseFloat(stringBaseMenor);
                    eAltura = altura.getText();
                    stringAltura = String.valueOf(eAltura);
                    floatAltura = Float.parseFloat(stringAltura);
                    area = ((floatBaseMaior + floatBaseMenor) * floatAltura) / 2;
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_trapezio);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área= ((B + b) * h)/2\n" +
                            "Área= ((" + res.format(floatBaseMaior) + " + " + res.format(floatBaseMenor) +
                            ") * " + res.format(floatAltura) + ")/2" +
                            "\nÁrea= (" + res.format(floatBaseMaior + floatBaseMenor) + " * " + res.format(floatAltura) + ")/2" +
                            "\nÁrea= " + res.format((floatBaseMaior + floatBaseMenor) * floatAltura) + " /2" +
                            "\nÁrea= " + res.format(area));
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                } else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Trapezio.this);
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
