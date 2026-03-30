package controller;

import model.estrutura.No;
import model.estrutura.Stack;

public class StackController{
    public StackController(){
        super();
    }

    public String teste() throws Exception{
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        //stack.pop();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        return stack.toString();
    }
}