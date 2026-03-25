package controller;

import model.estrutura.ListaDupla;


public class ListaDuplaController{
    public ListaDuplaController() {
        super();
    }

    public String teste() throws Exception{
        ListaDupla<String> lista = new ListaDupla<>();

        lista.adicionarPessoa("Abel");
        lista.adicionarPessoa("Angelo");
        lista.adicionarPessoa("Arnaldo");
        lista.adicionarPessoa("Jose");
        lista.adicionarPessoa("Jonas");
        lista.adicionarPessoa("Joao");
        lista.adicionarPessoa("Maria");
        lista.adicionarPessoa("Michele");

        lista.removerPessoa("Angelo");

        return lista.toString();
    }
}