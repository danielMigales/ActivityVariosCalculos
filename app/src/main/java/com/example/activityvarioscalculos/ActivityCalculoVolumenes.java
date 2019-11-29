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

public class ActivityCalculoVolumenes extends AppCompatActivity {

    private Button botonCalcularVolumen;
    private TextView resultado;
    private EditText base;
    private EditText altura;
    private Spinner selectorFiguras;
    private TextView valor1;
    private TextView valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_volumenes);

        Button botonCalcular = findViewById(R.id.botonCalcularVolumen);
        botonCalcular.setOnClickListener(myListener);
        resultado = (TextView) findViewById (R.id.casillaResultadoVolumen);
        base = findViewById (R.id.casillaBase);
        altura = findViewById (R.id.casillaAltura);
        valor1 = findViewById (R.id.tituloValor1);
        valor2 = findViewById (R.id.tituloValorAltura2);
        selectorFiguras = (Spinner) findViewById(R.id.spinnerFiguras);

        selectorFiguras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = String.valueOf(selectorFiguras.getSelectedItem());
                if (seleccion.equals("Esfera")){
                    altura.setEnabled(false);
                    altura.setFocusable(false);
                    altura.setCursorVisible(false);
                    altura.setKeyListener(null);
                    altura.setBackgroundColor(Color.TRANSPARENT);
                    valor1.setText("Radio");
                    valor2.setText("");
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

        String calculo = String.valueOf(calculoVolumen());
        String mensajeFinal = String.format("El volumen es %s", calculo);
        resultado.setText(mensajeFinal);
    }

    public double calculoVolumen(){

        String seleccion = String.valueOf(selectorFiguras.getSelectedItem());
        double valorBase = Double.parseDouble(String.valueOf(base.getText()));
        double valorAltura = Double.parseDouble(String.valueOf(altura.getText()));

        switch (seleccion) {
            case "Prisma":

            case "Cilindro":

                return Math.PI*(valorBase*valorBase)*valorAltura;
            case "Cubo":

            case "Esfera":
                return ((4/3) * Math.PI*(valorBase*valorBase*valorBase));
            default:
                throw new IllegalStateException("Unexpected value: " + seleccion);
        }
    }
}
