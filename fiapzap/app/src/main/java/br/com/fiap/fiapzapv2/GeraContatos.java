package br.com.fiap.fiapzapv2;

import java.util.ArrayList;
import java.util.List;

public class GeraContatos {
    public static List<Contato> getContatos(){
        List<Contato> contatos = new ArrayList<>();
        Contato contato1 = new Contato(
                "João da Silva",
                "(11) 48554",
                "Ocupado",
                R.drawable.p1
        );
        contatos.add(contato1);

        Contato contato2 = new Contato(
                "Marida de Lurdes",
                "(11) 485545",
                "Invisível",
                R.drawable.p2
        );
        contatos.add(contato2);

        return contatos;
    }
}
