package br.com.fiap.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirOutraActivity(View view) {
        Intent it = new Intent(this, OutraActivity.class);
        startActivity(it);
    }

    public void alterar1(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new TextoFragment())
                .commit();
    }

    public void alterar2(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new BannerFragment())
                .commit();
    }
}
