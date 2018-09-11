package fiap.com.persistenciaii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    EditText edtNomeCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new AppDatabase(this);
        edtNomeCliente = findViewById(R.id.edtNomecliente);

    }

    public void salvar(View view) {
        String nome = edtNomeCliente.getText().toString();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        db.inserirCliente(cliente);

        Toast.makeText(this, R.string.sucesso, Toast.LENGTH_SHORT).show();

        edtNomeCliente.setText("");
    }

    public void log(View view) {
        List<Cliente> clientes = db.getAllClientes();
        for (Cliente cliente : clientes){
            Log.d("MeuDebug", cliente.getNome());

        }
    }
}
