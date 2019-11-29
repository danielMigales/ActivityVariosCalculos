package com.example.activityvarioscalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityCalculoPitagoras extends AppCompatActivity {

    private Button botonCalcular;
    private TextView resultado;
    private EditText base;
    private EditText altura;
    private Spinner selector;
    private TextView valor1;
    private TextView valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_pitagoras);

        Button botonCalcular = findViewById(R.id.botonCalcularTeorema);
        botonCalcular.setOnClickListener(myListener);

        resultado = (TextView) findViewById (R.id.casillaResultadoTeorema);
        base = findViewById (R.id.casillaBase);
        altura = findViewById (R.id.casillaAltura);
        valor1 = findViewById (R.id.tituloValorBase);
        valor2 = findViewById (R.id.tituloValorAltura);
        selector = (Spinner) findViewById(R.id.spinnerPitagoras);

        selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = String.valueOf(selector.getSelectedItem());
                if (seleccion.equals("Cateto Mayor")){
                    valor1.setText("Cateto Menor");
                    valor2.setText("Hipotenusa");
                }
                else if(seleccion.equals("Cateto Menor")){
                    valor1.setText("Cateto Mayor");
                    valor2.setText("Hipotenusa");
                }
                else if (seleccion.equals("Hipotenusa")){
                    valor1.setText("Cateto Mayor");
                    valor2.setText("Cateto Menor");
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

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

        String calculo = String.valueOf(calcular());
        String mensajeFinal = String.format("El resultado es %s", calculo);
        resultado.setText(mensajeFinal);
    }

    public double calcular(){

        String seleccion = String.valueOf(selector.getSelectedItem());
        double valorBase = Double.parseDouble(String.valueOf(base.getText()));
        double valorAltura = Double.parseDouble(String.valueOf(altura.getText()));

        switch (seleccion) {
            case "Cateto Mayor":
                return (valorBase * valorAltura)/2;
            case "Cateto Menor":
                return (valorBase * valorAltura);
            case "Hipotenusa":
                return Math.sqrt(Math.pow(valorBase, 2) + Math.pow(valorAltura, 2));
            default:
                throw new IllegalStateException("Unexpected value: " + seleccion);
        }
    }
}
