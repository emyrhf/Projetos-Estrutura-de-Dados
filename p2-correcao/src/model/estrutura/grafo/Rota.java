package model.estrutura.grafo;

import java.util.List;

public class Rota{
    private List<String> cidades;
    private int kmTotal;
    private int kmBoa;
    private int kmRuim;
    private double mediaPeric;

    public Rota(List<String> cidades, int kmTotal, int kmBoa, int kmRuim, double mediaPeric){
        this.cidades = cidades;
        this.kmTotal = kmTotal;
        this.kmBoa = kmBoa;
        this.kmRuim = kmRuim;
        this.mediaPeric = mediaPeric;
    }

    @Override public String toString(){
        return (cidades + ":" + kmTotal + " KM, periculosidade média: " + mediaPeric + ", " + kmBoa + " KM de estrada boa, " + kmRuim + " KM de estrada ruim.");
    }
}