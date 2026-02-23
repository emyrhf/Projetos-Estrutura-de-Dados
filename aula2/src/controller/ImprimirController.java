package controller;
public class ImprimirController{
	public ImprimirController(){
		super();
	}
	public void Imprimir(int numero){
		if (numero >= 10) return;
		System.out.println("Número: " + numero);
		Imprimir(++numero);
	}
}