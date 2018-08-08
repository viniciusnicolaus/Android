package br.com.fiap.persistenciaexercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void Configuracao(View view) {
        Intent it = new Intent(SplashActivity.this, ConfiguracaoActivity.class);
        startActivity(it);
        finish();
    }
}
