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
        private EditText valorBase;
        private EditText valorAltura;
        private Spinner selector;
        private TextView tituloValorBase;
        private TextView tituloValorAltura;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculo_area);

            Button botonCalcular = findViewById(R.id.botonCalcularArea);
            botonCalcular.setOnClickListener(myListener);

            resultado = (TextView) findViewById (R.id.casillaResultadoArea);
            valorBase = findViewById (R.id.casillaBase);
            valorAltura = findViewById (R.id.casillaAltura);
            tituloValorBase = findViewById (R.id.tituloValorBase);
            tituloValorAltura = findViewById (R.id.tituloValorAltura);
            selector = (Spinner) findViewById(R.id.spinner);


            //Con este selector hago que se oculte la entrada de texto si se selecciona circulo, ya que
            //el circulo solo necesitamos el radio.
            //SE TIENE QUE ARREGLAR QUE AL VOLVER DE ESA SELECCION EL CAMPO PERMANECE OCULTO PARA LAS DEMAS

            selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    String seleccion = String.valueOf(selector.getSelectedItem());

                    if (seleccion.equals("Circulo")){
                        valorAltura.setVisibility(View.INVISIBLE);
                        tituloValorBase.setText("Radio");
                        tituloValorAltura.setText("");
                    }
                    else {
                        tituloValorBase.setText("Base");
                        tituloValorAltura.setText("Altura");
                        valorAltura.setVisibility(View.VISIBLE);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                    resultado.setText("Seleccione una figura.");
                }
            });
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

        //LOS CALCULOS SE HACEN EN ESTE METODO CON UN SWITCH SEGUN LA POSICION DEL SPINNER
        public double calculoArea(){

            String seleccion = String.valueOf(selector.getSelectedItem());
            double valor1 = Double.parseDouble(String.valueOf(this.valorBase.getText()));
            double valor2 = Double.parseDouble(String.valueOf(this.valorAltura.getText()));

            if(valorAltura.getText().toString().isEmpty()){
                resultado.setText("Introduzca un valor valido");
                valor2 = 0;
            }

            if (valorAltura.getText().toString().trim().equalsIgnoreCase("")){
                resultado.setText("Introduzca un valor valido");
                valor2 = 0;
            }


            switch (seleccion) {
                case "Triangulo":
                    return (valor1 * valor2)/2;
                case "Cuadrado":
                    return (valor1 * valor2);
                case "Rectangulo":
                    return (valor1 * valor2);
                case "Circulo":
                    return (3.1416 * Math.pow(valor1,2));
                default:
                    throw new IllegalStateException("Unexpected value: " + seleccion);
            }
        }
    }
