package com.magnus.mathfacil;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Bhaskara extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Bhaskara";
    private EditText a;
    private EditText b;
    private EditText c;
    private String A, B, C;
    private float delta;
    private int intA, intB, intC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhaskara);
        setTitle(TITULO_APPBAR);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1775D1")));
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        final Button calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(a.getText().toString()) && !"".equals(b.getText().toString()) && !"".equals(c.getText().toString())) {
                    A = a.getText().toString();
                    intA = Integer.parseInt(A);
                    B = b.getText().toString();
                    intB = Integer.parseInt(B);
                    C = c.getText().toString();
                    intC = Integer.parseInt(C);
                    delta = intB * intB - 4 * intA * intC;
                    int bQuadrado = intB * intB;
                    int multiplicaco = 4 * intA * intC;
                    int teste = bQuadrado - multiplicaco;
                    final TextView resultado = (TextView) findViewById(R.id.MeuTexto);
                    resultado.setTextColor(Color.BLACK);
                    final TextView semRaiz = (TextView) findViewById(R.id.texto_sem_raiz);
                    semRaiz.setTextColor(Color.BLACK);
                    if (teste >= 0) {
                        if (teste == 0) {
                            resultado.setText("");
                            semRaiz.setText("Δ=" + intB + "²-4." + intA + "." + intC + "\nΔ=" + bQuadrado + "+" +
                                    "" + multiplicaco * -1 + "\nΔ=" + delta + "\nx1=x2=-b/2*a" + "\nx1=x2=- " + intB +
                                    "/2* " + intA + "\nx1=x2=" + intB * -1 / 2 * intA);
                        } else {
                            float x1 = (float) (intB * -1 + Math.sqrt(delta));
                            x1 = x1 / (2 * intA);
                            float x2 = (float) (intB * -1 - Math.sqrt(delta));
                            x2 = x2 / (2 * intA);
                            semRaiz.setText("");
                            resultado.setText("Δ=" + intB + "²-4." + intA + "." + intC + "\nΔ=" + bQuadrado + "+" + multiplicaco * -1 + "\nΔ=" +
                                    "" + delta + "\n\nx1=(-b+-√Δ)/2.a" + "\nx1= - " + intB + "+ √" + delta + "\nx1= " + intB * -1 + "+√" + delta + "/2*" + intA + "" +
                                    "\nx1= " + intB * -1 + "+" + Math.sqrt(delta) + "/ " + intA * 2 + "\nx1=  " + (((intB * -1) + Math.sqrt(delta)) /(2 * intA)) + "\n\nx2=(-b-√Δ)/2.a" + "" +
                                    "\nx2= - " + intB + "- √" + delta + "\nx2= " + intB * -1 + "-√" + delta + "/2*" + intA + "" +
                                    "\nx2= " + intB * -1 + "-" + Math.sqrt(delta) + "/ " + intA * 2 + "\nx2=  " + (((intB * -1) - Math.sqrt(delta)) /(2 * intA)));
                        }
                    } else {
                        resultado.setText("");
                        semRaiz.setText("Δ=" + intB + "²-4." + intA + "." + intC + "\nΔ=" + bQuadrado + "+" + multiplicaco * -1 + "\nΔ=" + delta + "\nO valor de Δ não possui raiz. ");
                    }
                } else {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Bhaskara.this);
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
