package model.estrutura.grafo;

import model.estrutura.grafo.Estrada;
import model.estrutura.grafo.Rota;
import java.util.*;

public class GrafoMatriz<T>{
    private Estrada[][] matriz;
    private String[] labels;

    public GrafoMatriz(String[] labels){
        this.labels = labels;
        this.matriz = new Estrada[labels.length][labels.length];
    }

    public void link(String label1, String label2, int km, double peric, boolean estrada){
        int index_label1 = Arrays.asList(this.labels).indexOf(label1);
        int index_label2 = Arrays.asList(this.labels).indexOf(label2);

        Estrada e = new Estrada(km, peric, estrada);

        this.matriz[index_label1][index_label2] = e;
        this.matriz[index_label2][index_label1] = e;
    }

    public void remover(String label1, String label2){
        int index_label1 = Arrays.asList(this.labels).indexOf(label1);
        int index_label2 = Arrays.asList(this.labels).indexOf(label2);

        if(index_label1 == -1 || index_label2 == -1){
            return;
        }

        this.matriz[index_label1][index_label2] = null;
        this.matriz[index_label2][index_label1] = null;
    }

    public List<Rota> buscarRotas(String origem, String destino){
        List<Rota> rotas = new ArrayList<>();

        int inicio = Arrays.asList(labels).indexOf(origem);
        int fim = Arrays.asList(labels).indexOf(destino);

        boolean[] visitado = new boolean[labels.length];

        if(inicio == -1 || fim == -1){
            return rotas;
        }

        busca(inicio, fim, visitado, new ArrayList<>(), rotas, 0, 0, 0, 0, 0);

        return rotas;
    }

    public void busca(int atual, int destino, boolean[] visitado, List<String> caminho, List<Rota> rotas, int kmTotal, int kmBoa, int kmRuim, double somaPeric, int qntdArestas){
        visitado[atual] = true;

        caminho.add(labels[atual]);

        if(atual == destino){
            double media = 0;

            if(qntdArestas > 0){
                media = (somaPeric / qntdArestas);
            }

            rotas.add(new Rota(new ArrayList<>(caminho), kmTotal, kmBoa, kmRuim,  media));
        }else{
            for(int i=0; i<labels.length; i++){
                if(matriz[atual][i] != null && !visitado[i]){
                    Estrada e = matriz[atual][i];

                    busca(i, destino, visitado, caminho, rotas, kmTotal + e.getKm(), kmBoa + (e.isEstrada()?0:e.getKm()), kmRuim + (e.isEstrada()?e.getKm():0), somaPeric + e.getPeric(), qntdArestas + 1);
                }
            }
        }

        caminho.remove(caminho.size()-1);
        visitado[atual] = false;
    }


    @Override public String toString(){
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<this.labels.length; i++){
            builder.append(this.labels[i] + ": ");
            for(int j=0;j<this.labels.length; j++){
                if(this.matriz[i][j] != null){
                    builder.append(this.labels[j] + " ");
                }
            }
            builder.append("\r\n");
        }
        return(builder.toString());
    }
}