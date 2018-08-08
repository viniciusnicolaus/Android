package br.com.fiap.persistenciaexercicio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class ConfiguracaoActivity extends AppCompatActivity {

    SharedPreferences sp;
    CheckBox ckbExibir;
    SeekBar skbTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        ckbExibir = findViewById(R.id.ckbExibir);
        skbTempo = findViewById(R.id.skbTempo);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean exibir = sp.getBoolean("exibir", true);
        int tempo = sp.getInt("tempo", 10000);
        skbTempo.setProgress(tempo);
        ckbExibir.setChecked(exibir);

    }

    public void salvar(View view) {
        boolean exibir = ckbExibir.isChecked();
        int tempo = skbTempo.getProgress();

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("exibir", exibir);
        editor.putInt("tempo", tempo);
        editor.commit();

        Toast.makeText(this, R.string.configuracao_salva, Toast.LENGTH_SHORT).show();

        finish();

    }
}
