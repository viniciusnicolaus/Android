package br.com.fiap.projetopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtValor;
    RadioGroup rdgPizzas;
    CheckBox ckbBordaRecheada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgPizzas = findViewById(R.id.rdgPizzas);
        ckbBordaRecheada = findViewById(R.id.ckbBordaRecheada);
        txtValor = findViewById(R.id.valor);
    }
    public void Calcular(View view) {

        double valorTotal = 0;
        int pizza = rdgPizzas.getCheckedRadioButtonId();
        switch (pizza){
            case R.id.rdbMussarela:
                valorTotal = 10;
                break;
            case R.id.rdbCalabresa:
                valorTotal = 15;
                break;
            case R.id.rdbPortuguesa:
                valorTotal = 20;
                break;
        }
        if(ckbBordaRecheada.isChecked()){
            valorTotal += 5;
        }
        txtValor.setText(String.format("R$ %.2f" + valorTotal));

    }
}
