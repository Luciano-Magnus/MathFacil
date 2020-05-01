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

public class Retangulo extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Retângulo";
    EditText base, altura;
    Editable eBase, eAltura;
    String stringBase, stringAltura;
    Float floatBase, floatAltura, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));

        base = findViewById(R.id.base);
        altura = findViewById(R.id.altura);
        final Button calcular = findViewById(R.id.calcular_retangulo);
        calcular.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!"".equals(base.getText().toString()) && !"".equals(altura.getText().toString())) {
                    eBase = base.getText();
                    eBase = base.getText();
                    stringBase = String.valueOf(eBase);
                    floatBase = Float.parseFloat(stringBase);
                    eAltura = altura.getText();
                    stringAltura = String.valueOf(eAltura);
                    floatAltura = Float.parseFloat(stringAltura);
                    area = floatBase * floatAltura;
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_retangulo);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área= b * h\nÁrea= " + res.format(floatBase) + " * " + res.format(floatAltura) + "\n" +
                            "Área= " + res.format(area));
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                } else {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Retangulo.this);
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
