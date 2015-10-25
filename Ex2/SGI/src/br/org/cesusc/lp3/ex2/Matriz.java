package br.org.cesusc.lp3.ex2;

public class Matriz {
	private double[][] elementos;
	private int numLinhas;
	private int numColunas;
	
	public Matriz(int linhas, int colunas){
		numLinhas = linhas;
		numColunas = colunas;
		elementos = new double[numLinhas][numColunas];
	}
	
	public void print() {
		for (int i = 0; i < numLinhas; i++){
			System.out.print("[");
			for (int j = 0; j < numColunas; j++){
				System.out.print(elementos[i][j]);
				System.out.print(" ");
			}
			System.out.println("]");
		}
	}
	
	public void set(int i, int j, double x){
		elementos[i][j] = x;
	}
	
	public double get(int i, int j){
		return elementos[i][j];
	}
	
	public Matriz somar(Matriz B){
		Matriz C = new Matriz(numLinhas, numColunas);
		for (int i = 0; i < numLinhas; i++){
			for (int j = 0; j < numColunas; j++){
				double soma = this.get(i,j) + B.get(i,j);
				C.set(i, j, soma);
			}
		}
		return C;
	}

	public Matriz multiplicar(Matriz B) {
		// TODO Implementar!
		return new Matriz(3, 3);
	}	
	
	public int getNumLinhas() {
		return numLinhas;
	}

	public int getNumColunas() {
		return numColunas;
	}

	public Matriz getRotacao(double radianos) {
		//TODO implementar segundo formula
		return new Matriz(3, 3);
	}

	public Matriz getTranslacao(double dx, double dy) {
		//TODO implementar segundo formula
		return new Matriz(3, 3);
	}
	
	public Matriz getEscalonamento(double sx, double sy) {
		//TODO implementar segundo formula
		return new Matriz(3, 3);
	}
}
