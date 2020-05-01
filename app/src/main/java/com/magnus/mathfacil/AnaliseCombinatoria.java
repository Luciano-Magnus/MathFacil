package com.magnus.mathfacil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.DelayQueue;

public class AnaliseCombinatoria extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Análise Combinatória";
    private EditText n;
    private EditText p;
    private Editable A, B;
    private  int intN, intP, fatorial;
    int f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise_combinatoria);
        n= findViewById(R.id.n);
        p= findViewById(R.id.p);
        final TextView resultado_analise = (TextView) findViewById(R.id.res_analise);
        resultado_analise.setTextColor(Color.BLACK);
        final Button calcular= findViewById(R.id.calcular_analise);
        calcular.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                A = n.getText();
                String stringA = String.valueOf(A);
                intN = Integer.parseInt(stringA);
                B = p.getText();
                String stringB = String.valueOf(B);
                intP = Integer.parseInt(stringB);
                fatorial = intN;
                f=intN;
                int parar = intN - intP;
                do {
                    f = f * (intN - 1);
                    intN--;
                    resultado_analise.setText(""+fatorial+"!="+ intN);
                } while (intN > 0);
            }
            });
        }
        }
