package fiap.com.persistenciaii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AppDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_BANE = "AppDatabase";
    public static final int VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    public AppDatabase(Context context) {
        super(context, "AppDataBase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `"+TB_CLIENTE+"` (" +
                            "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                            "`nome` TEXT NOT NULL" +
                            ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirCliente(Cliente cLiente) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", cLiente.getNome());

        db.insert(TB_CLIENTE, null, cv);
    }

    public void updateCliente(Cliente cliente){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", cliente.getNome());

        db.update(
                TB_CLIENTE,
                cv,
                "id = ?",
                new String[]{ String.valueOf(cliente.getId()) }
                );
    }

    public void deleteCliente(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
                TB_CLIENTE,
                "id = ?",
                new String[]{ String.valueOf(id) });
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                TB_CLIENTE,
                new String[]{"id", "nome"},
                null,
                null,
                null,
                null,
                "nome"
        );
        //Manda ir para o primeiro registro, garante que esta no primeiro registro
        //c.moveToFirst();

        while (c.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(c.getInt(0));
            cliente.setNome( c.getString(1));

            clientes.add(cliente);
        }
        //Manda fechar o cursor
        c.close();

        return clientes;
    }
}
