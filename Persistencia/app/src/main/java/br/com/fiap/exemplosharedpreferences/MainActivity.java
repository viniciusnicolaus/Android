package br.com.fiap.exemplosharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtSenha;
    CheckBox ckbManterConectado;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        ckbManterConectado = findViewById(R.id.ckbManterConectado);

        sp = getSharedPreferences("login",MODE_PRIVATE);

        Boolean conectado = sp.getBoolean("conectado", false);
        if(conectado) {
            abrirDashboard();
        }
    }

    public void login(View view) {
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if (usuario.equals("fiap") && senha.equals("fiap")){

            if( ckbManterConectado.isChecked()) {
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("usuario", usuario);
                edit.putString("senha", senha);
                edit.putBoolean("conectado", true);

                edit.commit();
            }

            abrirDashboard();

        }else{
            Toast.makeText(this, R.string.login_invalido, Toast.LENGTH_SHORT).show();
        }
    }
    private void abrirDashboard() {
        Intent it = new Intent(this, DashboardActivity.class);
        startActivity(it);
    }
}
