package model.estrutura.grafo;

public class Estrada{
    private int km;
    private double peric;
    private boolean estrada;

    public Estrada(int km, double peric, boolean estrada){
        this.km = km;
        this.peric = peric;
        this.estrada = estrada;
    }

    public int getKm(){
        return km;
    }

    public double getPeric(){
        return peric;
    }

    public boolean isEstrada(){
        return estrada;
    }
}