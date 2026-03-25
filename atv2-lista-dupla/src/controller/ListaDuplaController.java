package controller;

import model.estrutura.ListaDupla;

public class ListaDuplaController {
    public ListaDuplaController() {
        super();
    }

    public String teste() {
        ListaDupla<String> lista = new ListaDupla<>();

        lista.insertOrdenado("felipe");
        lista.insertOrdenado("Gustavo");
        lista.insertOrdenado("debora");
        lista.insertOrdenado("Emily");
        lista.insertOrdenado("ana");
        lista.insertOrdenado("Carlos");
        lista.insertOrdenado("bruno");

        return lista.imprimirAsc() + "\n" + lista.imprimirDesc();
    }
}
