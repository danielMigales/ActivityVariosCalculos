package com.example.activityvarioscalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.activityvarioscalculos.LoginActivity.*;

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton =(Button) findViewById(R.id.botonArea);
        boton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCalculoArea.class);
                startActivityForResult(intent,0); }
        });

        boton =(Button) findViewById(R.id.botonVolumenes);
        boton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCalculoVolumenes.class);
                startActivityForResult(intent,0); }
        });

        boton =(Button) findViewById(R.id.botonPerimetros);
        boton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCalculoPerimetro.class);
                startActivityForResult(intent,0); }
        });

        boton =(Button) findViewById(R.id.botonPitagoras);
        boton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCalculoPitagoras.class);
                startActivityForResult(intent,0); }
        });

        Intent intent = getIntent();
        String nombre = getIntent().getStringExtra("nombre");

        bienvenida = (TextView) findViewById(R.id.textViewBienvenida);
        bienvenida.setText("Hola, " + nombre);
    }

        }

