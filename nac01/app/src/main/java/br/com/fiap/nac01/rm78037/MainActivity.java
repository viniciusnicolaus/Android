package br.com.fiap.nac01.rm78037;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgProdutos;
    EditText edtMedida;
    CheckBox chkUltraFrete;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgProdutos = findViewById(R.id.rdgProdutos);
        edtMedida = findViewById(R.id.edtMedida);
        chkUltraFrete = findViewById(R.id.chkUltraFrete);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {

        //
        // Validações
        //
        if (edtMedida.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.informe_medida, Toast.LENGTH_SHORT).show();
            return;
        }
        double resultado = 0;

        int selecionado = rdgProdutos.getCheckedRadioButtonId();

        switch (selecionado) {
            case R.id.rdbPisoBanco:
                resultado = 24.9;
                break;
            case R.id.rdbPisoAlbania:
                resultado = 11.9;
                break;
            case R.id.rdbPorcelanato:
                resultado = 39.9;
                break;
            case R.id.rdbRevestimento:
                resultado = 16.9;
                break;
        }

        double medida = Double.parseDouble(edtMedida.getText().toString());

        resultado *= medida;

        if (chkUltraFrete.isChecked()) {
            resultado *= 1.3;
        }

        txtResultado.setText(String.format("R$ %.2f",resultado));
    }
}
