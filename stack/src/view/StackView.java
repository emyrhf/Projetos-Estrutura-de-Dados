package view;

import controller.StackController;

public class StackView{
    public static void main(String [] args){
        try{
            StackController obj = new StackController();
            System.out.println(obj.teste());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}