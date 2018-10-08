package br.com.fiap.fiapzapv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContatoAdapter
        extends RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder> {

    private Context context;
    private List<Contato> contatos;

    public ContatoAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.contatos = contatos;
    }

    @NonNull
    @Override
    public ContatoAdapter.ContatoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(this.context)
                .inflate(R.layout.recyclerview_contatos, viewGroup, false);

        return new ContatoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatoAdapter.ContatoViewHolder contatoViewHolder, int i) {
        final Contato contato = this.contatos.get(i);

        contatoViewHolder.imgContato.setImageResource( contato.getImagem() );
        contatoViewHolder.txtNome.setText( contato.getNome() );
        contatoViewHolder.txtTelefone.setText( contato.getTelefone() );
        contatoViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contato.getStatus(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.contatos.size();
    }


    public class ContatoViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imgContato;
        TextView txtNome;
        TextView txtTelefone;

        public ContatoViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            imgContato = cardView.findViewById(R.id.imgContato);
            txtNome = cardView.findViewById(R.id.txtNome);
            txtTelefone = cardView.findViewById(R.id.txtTelefone);
        }
    }
}
