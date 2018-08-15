package com.example.danielbustamante.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ConversorActivity extends AppCompatActivity {
    private EditText ein;
    private TextView tp, te,td;
    private String  moneda = "P";
    private String moneda1 = "";
    private Button bcalcular;

    final private double factorPesoEuro = 0.00030;
    final private double factorPesoDolar = 0.00034;
    final private double factorEuroPeso = 3349.20;
    final private double factorEuroDolar = 1.14;
    final private double factorDolarPeso = 2982.35;
    final private double factorDolarEuro = 0.88;



    public void onRadioButtonClicked(View view) {
        int id1 = view.getId();
        int id = view.getId();

        if (id == R.id.rbp ){
            moneda= "P";
        }else if (id == R.id.rbe){
            moneda ="E";
        }else
            moneda = "D";

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        ein = findViewById(R.id.ein);
        tp = findViewById(R.id.tp);
        te = findViewById(R.id.te);
        td = findViewById(R.id.td);
        bcalcular= findViewById(R.id.bcalcular);

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorcambio=0, peso=0, euro=0, dolar=0;
                String caja;

                 caja =ein.getText().toString();

                          if (caja.equals("")){
                    Toast.makeText(getApplicationContext(), "Digite Un Valor",
                            Toast.LENGTH_SHORT).show();
                } else {
                              valorcambio = Double.parseDouble(ein.getText().toString());
                          if (moneda.equals("P")) {
                            peso=valorcambio;
                            euro=valorcambio*factorPesoEuro;
                            dolar=valorcambio*factorPesoDolar;
                        } else if (moneda.equals("E")) {
                        peso=valorcambio*factorEuroPeso;
                        euro=valorcambio*1;
                        dolar = valorcambio*factorEuroDolar;
                    } else if (moneda.equals("D")){
                        peso = valorcambio * factorDolarPeso;
                        euro= valorcambio*factorDolarEuro;
                        dolar= valorcambio*1;
                           }
                tp.setText(String.valueOf(peso +"Pesos"));
                te.setText(String.valueOf(euro+ "Euros"));
                td.setText(String.valueOf(dolar +"Dolar"));


            }
            }
        });



    }


}
