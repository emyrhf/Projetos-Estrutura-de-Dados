package view;

import java.util.Scanner;
import controller.GrafoMatrizController;

public class GrafoMatriz{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Cidade de origem: ");
            String origem = scanner.nextLine().toUpperCase();

            System.out.println("Cidade de destino: ");
            String destino = scanner.nextLine().toUpperCase();

            GrafoMatrizController obj = new GrafoMatrizController();
            System.out.println(obj.buscarRotas(origem, destino));

        }catch(Exception e){
            e.printStackTrace();
        }
        scanner.close();
    }
}