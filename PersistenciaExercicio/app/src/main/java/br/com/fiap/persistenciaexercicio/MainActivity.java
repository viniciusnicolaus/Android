package br.com.fiap.persistenciaexercicio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean exibir = sp.getBoolean("exibir", true);
        int tempo = sp.getInt("tempo", 5000);

        if (exibir) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Lógica para abrir a outra activity aqui
                    Intent it = new Intent(MainActivity.this, SplashActivity.class);
                    startActivity(it);
                    finish(); //Finalizamos essa activity para o usuárilto não voar
                }
            }, tempo);
        }else{
           abrirDashboard();
        }
    }
    private void abrirDashboard(){
        Intent it = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(it);
        finish();
    }
}
