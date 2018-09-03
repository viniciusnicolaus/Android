package com.fiap.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lstContatos;
    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstContatos = findViewById(R.id.lstContatos);

        //Chamando o método para gerar a lista
        //contatos = contatos.gerarContatos();

        ContatoAdapter adapter = new ContatoAdapter(this, contatos);

        lstContatos.setAdapter(adapter);
        lstContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contato contato = contatos.get(i);

                Toast.makeText(MainActivity.this, contato.getNome(), Toast.LENGTH_SHORT).show();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://douglascabral.com.br/aula-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitContatosInterface api = retrofit.create(RetrofitContatosInterface.class);
        api.getContatos().enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
                List<Contato> contatos = response.body();

                for (Contato c : contatos) {
                    Log.d("FIAP", c.getNome());
                    Log.d("FIAP", c.getTelefone());
                    Log.d("FIAP", c.getStatus());
                    Log.d("FIAP", String.valueOf(R.drawable.p1));
                }
                Toast.makeText(MainActivity.this, R.string.request_finalizada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.ocorreu_um_erro,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
