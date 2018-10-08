package br.com.fiap.fiapzapv2;

import java.util.ArrayList;
import java.util.List;

public class GeraContatos {
    public static List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();

        Contato contato1  = new Contato(
                "João da Silva",
                "(11) 1111-1111",
                "Ocupado",
                R.drawable.p1
        );

        contatos.add(contato1);

        Contato contato2 = new Contato(
                "Maria de Lurdes",
                "(11) 2222-2222",
                "Disponível",
                R.drawable.p2
        );

        contatos.add(contato2);

        return contatos;
    }
}
