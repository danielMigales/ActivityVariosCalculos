package com.example.activityvarioscalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button boton;
    private TextView nombre;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        boton =(Button) findViewById(R.id.botonLogin);
        nombre = (TextView) findViewById(R.id.textviewNombreUsuario);
        password = (TextView) findViewById(R.id.textviewPassword);
        boton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("nombre", nombre.getText().toString());
                startActivityForResult(intent,0); }
        });
    }
}
