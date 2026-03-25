package model.estrutura;

public class No<T> {

    private ListaSimples<String> lista;
    private T valor;
    private No<T> proximo;
    private No<T> anterior;

    public No(T valor) {
        this.proximo = null;
        this.anterior = null;
        this.valor = valor;
        this.lista = new ListaSimples<>();
    }
    
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    public ListaSimples<String> getLista() {
        return lista;
    }


    @Override
    public String toString() {
        return valor.toString();
    }
}