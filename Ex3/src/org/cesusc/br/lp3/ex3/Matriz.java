package org.cesusc.br.lp3.ex3;

public class Matriz {
	private double[][] elementos;
	private int numLinhas;
	private int numColunas;

	public Matriz(int linhas, int colunas) {
		numLinhas = linhas;
		numColunas = colunas;
		elementos = new double[numLinhas][numColunas];
	}

	public void print() {
		for (int i = 0; i < numLinhas; i++) {
			System.out.print("[");

			for (int j = 0; j < numColunas; j++) {
				System.out.print(elementos[i][j]);
				System.out.print(" ");
			}

			System.out.println("]");
		}
	}

	public void set(int i, int j, double x) {
		elementos[i][j] = x;
	}

	public double get(int i, int j) {
		return elementos[i][j];
	}

	public Matriz somar(Matriz B) {
		Matriz C = new Matriz(numLinhas, numColunas);

		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				double soma = this.get(i, j) + B.get(i, j);
				C.set(i, j, soma);
			}
		}

		return C;
	}

	public Matriz multiplicar(Matriz B) {
		Matriz C = new Matriz(this.getNumLinhas(), B.getNumColunas());

		for (int i = 0; i < C.getNumLinhas(); i++) {
			for (int j = 0; j < C.getNumColunas(); j++) {
				double soma = 0.0;
				for (int k = 0; k < this.getNumColunas(); k++) {
					soma += this.get(i, k) * B.get(k, j);
				}
				C.set(i, j, soma);
			}
		}

		return C;
	}

	public static Matriz getIdentidade(int tamanho) {
		Matriz id = new Matriz(tamanho, tamanho);

		for (int i = 0; i < tamanho; i++) {
			id.set(i, i, 1);
		}

		return id;
	}

	public static Matriz getTranslacao(double dx, double dy) {
		Matriz t = getIdentidade(3);

		t.set(2, 0, dx);
		t.set(2, 1, dy);

		return t;
	}

	public static Matriz getEscala(double sx, double sy) {
		Matriz s = getIdentidade(3);

		s.set(0, 0, sx);
		s.set(1, 1, sy);

		return s;
	}

	public static Matriz getRotacao(double angulo) {
		// TODO!
		return null;
	}

	public int getNumLinhas() {
		return numLinhas;
	}

	public int getNumColunas() {
		return numColunas;
	}

}
