package br.com.fiap.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    Context context;
    List<Contato> contatos;

    public ContatoAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.contatos = contatos;
    }

    //Quantidade de itens que a lista tem que retornar
    @Override
    public int getCount() {
        return this.contatos.size();
    }

    //Pegando item pela posição dele
    @Override
    public Object getItem(int i) {
        return this.contatos.get(i);
    }
    //Id para cada item
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Monta a view
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        Contato contato = this.contatos.get(i);

        View v = layoutInflater.inflate(R.layout.listview_contato, null);

        ImageView imgContato = v.findViewById(R.id.imgContato);
        TextView txtNome     = v.findViewById(R.id.txtNome);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);

        imgContato.setImageResource(contato.getImagem());
        txtNome.setText(contato.getNome());
        txtTelefone.setText(contato.getTelefone());

        return v;
    }
}
