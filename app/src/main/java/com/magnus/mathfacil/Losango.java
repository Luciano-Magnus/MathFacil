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

public class Losango extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Losango";
    EditText diagonalMaior, diagonalMenor;
    Editable eDiagonalMaior, eDiagonalMenor;
    String stringDiagonalMenor, stringDiagonalMaior;
    Float floatDiagonalMaior, floatDiagonalMenor, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losango);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));

        diagonalMaior = findViewById(R.id.diagonal_maior);
        diagonalMenor = findViewById(R.id.diagonal_menor);
        final Button calcular = findViewById(R.id.calcular_losango);
        calcular.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!"".equals(diagonalMaior.getText().toString()) && !"".equals(diagonalMenor.getText().toString())) {
                    eDiagonalMaior = diagonalMaior.getText();
                    eDiagonalMenor = diagonalMenor.getText();
                    stringDiagonalMaior = String.valueOf(eDiagonalMaior);
                    stringDiagonalMenor = String.valueOf(eDiagonalMenor);
                    floatDiagonalMaior = Float.parseFloat(stringDiagonalMaior);
                    floatDiagonalMenor = Float.parseFloat(stringDiagonalMenor);
                    area = (floatDiagonalMaior * floatDiagonalMenor) / 2;
                    DecimalFormat res = new DecimalFormat("0.00");
                    TextView resultado = (TextView) findViewById(R.id.Resultado_losango);
                    resultado.setTextColor(Color.BLACK);
                    resultado.setText("Área= (D * d)/2\nÁrea= (" + res.format(floatDiagonalMaior) + " * " + res.format(floatDiagonalMenor) +
                            ")/2\nÁrea= " + res.format(floatDiagonalMaior * floatDiagonalMenor) + " /2\nÁrea= " + res.format(area));
                    TextView obs = (TextView) findViewById(R.id.Obs);
                    obs.setText("ATENÇÃO: Utilize a unidade de medida pedida no problema.\nExemplo: " + res.format(area) + "cm²");
                } else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Losango.this);
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
