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

public class Cilindro extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Cilindro";
    EditText raio, altura;
    Editable eAltura, eRaio;
    String stringRaio, stringAltura;
    Float floatRaio;
    Float floatAltura;
    double area;
    double AB;
    double AL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));

        raio = findViewById(R.id.raio);
        altura = findViewById(R.id.altura);
        final Button calcular = findViewById(R.id.calcular_cilindro);
        calcular.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!"".equals(raio.getText().toString()) && !"".equals(altura.getText().toString())) {
                    eRaio = raio.getText();
                    stringRaio = String.valueOf(eRaio);
                    floatRaio = Float.parseFloat(stringRaio);
                    eAltura = altura.getText();
                    stringAltura = String.valueOf(eAltura);
                    floatAltura = Float.parseFloat(stringAltura);
                    AB = 3.14 * floatRaio * floatRaio;
                    AL = 2 * 3.14 * floatRaio * floatAltura;
                    area = 2 * AB + AL;
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_cilindro);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área Base= π * r²\nÁrea Base = 3,14 * " + res.format(floatRaio) + "²" +
                            "\nÁrea Base= " + res.format(AB) + "\nÁrea Lateral= Al = 2π * r * h" +
                            "\nÁrea Lateral= 2*3,14*" + res.format(floatRaio) + "*" + res.format(floatAltura) +
                            "\nÁrea Lateral= " + res.format(AL) + "\nÁrea= 2 * Ab + Al\nÁrea= 2 * " + res.format(AB) +
                            " + " + res.format(AL) + "\nÁrea= " + res.format(2 * AB) + " + " + res.format(AL) + "\nÁrea= " + res.format(area));
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                } else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Cilindro.this);
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
