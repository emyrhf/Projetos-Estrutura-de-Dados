package controller;

import java.util.List;
import model.estrutura.grafo.GrafoMatriz;
import model.estrutura.grafo.Rota;

public class GrafoMatrizController{
    public GrafoMatrizController(){
        super();
    }

    public String buscarRotas(String origem, String destino) throws Exception{
        String[] cidades = new String[]{"UBERLANDIA", "UBERABA", "SAO JOSE DO RIO PRETO", "RIBEIRAO PRETO", "CAMPINA VERDE", "PATOS DE MINAS", "ARAXA"};
        GrafoMatriz g = new GrafoMatriz(cidades);

        g.link("SAO JOSE DO RIO PRETO", "CAMPINA VERDE", 210, 0.5, true);//a
        g.link("UBERLANDIA", "CAMPINA VERDE", 156, 0.4, false);//b
        g.link("UBERLANDIA", "UBERABA", 105, 0.1, false);//c
        g.link("UBERLANDIA", "PATOS DE MINAS", 216, 0.7, true);//d
        g.link("PATOS DE MINAS", "ARAXA", 155, 0.7, true);//e
        g.link("UBERABA", "RIBEIRAO PRETO", 176, 0.1, false);//f
        g.link("SAO JOSE DO RIO PRETO", "UBERABA", 172, 0.1, false);//g
        g.link("UBERABA", "ARAXA", 166, 0.4, false);//h

        StringBuilder builder = new StringBuilder();
        List<Rota> rotas = g.buscarRotas(origem, destino);

        if(rotas.isEmpty()){
            return "Nenhuma rota encontrada";
        }
        for(Rota r: rotas){
            builder.append(r);
            builder.append("\n\n");
        }

        return builder.toString();
    }
}

