package br.com.fiap.listagem;

import java.util.ArrayList;
import java.util.List;

public class GeraContatos {

    //Clase para epresentar um banco de dados fake instanciando a lista
    public static List<Contato> gerarContatos(){
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato(
                "Pedro",
                "(11)777",
                "DALE",
                R.drawable.p1
        );
        contatos.add(contato1);

        Contato contato2 = new Contato(
                "Chica",
                "(12)777",
                "DEILE",
                R.drawable.p2
        );
        contatos.add(contato2);

        return contatos;
    }
}
