package br.com.fiap.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkEstouAprendendo;
    RadioGroup rdgDificuldade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkEstouAprendendo = findViewById(R.id.chkEstouAprendendo);
        rdgDificuldade = findViewById(R.id.rdgDificuldade);
    }
    public void salvar(View view) {
        boolean checado = chkEstouAprendendo.isChecked();
        Toast.makeText(
                this,
                getString(R.string.estou_aprendendo) + checado,
                Toast.LENGTH_SHORT
        ).show();

        int selecionado = rdgDificuldade.getCheckedRadioButtonId();
        String msg = "";

        switch (selecionado) {
            case R.id.rdbFacil:
                msg = getString(R.string.esta_facil);
                break;
            case R.id.rdbMedio:
                msg = getString(R.string.esta_medio);
                break;
            case R.id.rdbDificil:
                msg = getString(R.string.esta_dificil);
                break;
            default:
                msg = getString(R.string.nada);
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
