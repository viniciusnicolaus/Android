package br.com.fiap.petshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView txtValor;
    RadioGroup rdgCachorro ;

    CheckBox ckbFemea;
    CheckBox ckbAdestrado;
    CheckBox ckbVacina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgCachorro = findViewById(R.id.rdgCachorro);

        ckbFemea = findViewById(R.id.ckbFemea);
        ckbAdestrado = findViewById(R.id.ckbAdestrado);
        ckbVacina = findViewById(R.id.ckbVacina);

        txtValor = findViewById(R.id.valor);

    }

    public void calcular(View view) {
        double valorTotal = 0;

        int cachorro = rdgCachorro.getCheckedRadioButtonId();

        switch (cachorro) {
            case R.id.rdbBorder:
                valorTotal = 800;
                break;
            case R.id.rdbPitBull:
                valorTotal = 750;
                break;
            case R.id.rdbpastorAlemao:
                valorTotal = 700;
                break;
            case R.id.rdbPastorCanadense:
                valorTotal = 800;
                break;
        }
        if(ckbFemea.isChecked()){
            valorTotal += 180;
        }
        if(ckbVacina.isChecked()){
            valorTotal += 200;
        }
        if(ckbAdestrado.isChecked()){
            valorTotal += 400;
        }
        txtValor.setText(String.format("R$ %.2f",valorTotal));

    }
}
