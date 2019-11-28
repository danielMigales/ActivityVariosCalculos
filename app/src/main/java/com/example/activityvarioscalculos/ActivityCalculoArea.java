package com.example.activityvarioscalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityCalculoArea extends AppCompatActivity {

        private Button botonCalcular;
        private TextView resultado;
        private EditText base;
        private EditText altura;
        private Spinner selector;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculo_area);

            Button botonCalcular = findViewById(R.id.botonCalcularArea);
            botonCalcular.setOnClickListener(myListener);

            resultado = (TextView) findViewById (R.id.casillaResultadoArea);
            base = findViewById (R.id.casillaBase);
            altura = findViewById (R.id.casillaAltura);
            selector = (Spinner) findViewById(R.id.spinner);
            //selector.setOnItemSelectedListener(this);
        }

        private View.OnClickListener myListener = new View.OnClickListener() {;

            public void onClick(View v) {
                CambiarMensaje(v);
            }
        };


        public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
        {
            String item = parent.getItemAtPosition(pos).toString();

        }

        public void CambiarMensaje ( View v){

            String calculo = String.valueOf(calculoArea());
            String mensajeFinal = String.format("El area es %s", calculo);
            resultado.setText(mensajeFinal);
        }

        public double calculoArea(){

            String seleccion = String.valueOf(selector.getSelectedItem());
            double valorBase = Double.parseDouble(String.valueOf(base.getText()));
            double valorAltura = Double.parseDouble(String.valueOf(altura.getText()));

            switch (seleccion) {
                case "Triangulo":
                    return (valorBase * valorAltura)/2;
                case "Cuadrado":
                    return (valorBase * valorAltura);
                case "Rectangulo":
                    return (valorBase * valorAltura);
                case "Circulo":
                    return (3.1416 * Math.pow(valorBase,2));
                default:
                    throw new IllegalStateException("Unexpected value: " + seleccion);
            }


        }

    }
