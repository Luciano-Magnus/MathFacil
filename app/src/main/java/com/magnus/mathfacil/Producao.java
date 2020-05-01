package com.magnus.mathfacil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Producao extends Activity {
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producao);
        TextView texto = (TextView) findViewById(R.id.textView);
        texto.setTextColor(Color.BLACK);


    }
}
