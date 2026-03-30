package controller;

import model.estrutura.No;
import model.estrutura.FilaFifo;

public class FilaFifoController{
    public FilaFifoController(){
        super();
    }

    public String teste() throws Exception{
        FilaFifo fila = new FilaFifo();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.dequeue();
        
        return fila.toString();
    }
}