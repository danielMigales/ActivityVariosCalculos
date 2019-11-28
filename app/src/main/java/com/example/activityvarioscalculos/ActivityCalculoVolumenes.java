package com.example.activityvarioscalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityCalculoVolumenes extends AppCompatActivity {

    private Button botonCalcularVolumen;
    private TextView resultado;
    private EditText base;
    private EditText altura;
    private Spinner selectorFiguras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_volumenes);

        Button botonCalcular = findViewById(R.id.botonCalcularVolumen);
        botonCalcular.setOnClickListener(myListener);

        resultado = (TextView) findViewById (R.id.casillaResultadoVolumen);
        base = findViewById (R.id.casillaBase);
        altura = findViewById (R.id.casillaAltura);
        selectorFiguras = (Spinner) findViewById(R.id.spinnerFiguras);
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

        String calculo = String.valueOf(calculoPerimetro());
        String mensajeFinal = String.format("El perimetro es %s", calculo);
        resultado.setText(mensajeFinal);
    }

    public double calculoPerimetro(){

        String seleccion = String.valueOf(selectorFiguras.getSelectedItem());
        double valorBase = Double.parseDouble(String.valueOf(base.getText()));
        double valorAltura = Double.parseDouble(String.valueOf(altura.getText()));

        switch (seleccion) {
            case "Triangulo":
                return valorBase + valorAltura + valorAltura;
            case "Cuadrado":
                return 2*(valorBase + valorAltura);
            case "Rectangulo":
                return 2*(valorBase + valorAltura);
            case "Circulo":
                return 2*Math.PI*valorBase;
            default:
                throw new IllegalStateException("Unexpected value: " + seleccion);
        }


    }

}
