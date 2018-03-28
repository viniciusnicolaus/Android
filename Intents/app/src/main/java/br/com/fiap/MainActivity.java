package br.com.fiap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
    }

    public void salvar(View view) {


        String nome = edtNome.getText().toString();

        Intent it = new Intent(this, ConfirmacaoActivity.class);
        it.putExtra("nome",nome);

        startActivity(it);


    }
}
