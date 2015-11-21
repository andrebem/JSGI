package org.cesusc.br.lp3;

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

	public Matriz mais(Matriz B) {
		Matriz C = new Matriz(numLinhas, numColunas);
		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				double soma = this.get(i, j) + B.get(i, j);
				C.set(i, j, soma);
			}
		}
		return C;
	}

	public Matriz vezes(Matriz B) {
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

	public static Matriz identidade(int tamanho) {
		Matriz id = new Matriz(tamanho, tamanho);
		for (int i = 0; i < tamanho; i++) {
			id.set(i, i, 1);
		}

		return id;
	}

	public static Matriz translacao(double dx, double dy) {
		Matriz t = identidade(3);
		t.set(2, 0, dx);
		t.set(2, 1, dy);
		return t;
	}

	public static Matriz escalonamento(double sx, double sy) {
		Matriz s = identidade(3);
		s.set(0, 0, sx);
		s.set(1, 1, sy);
		return s;
	}

	public static Matriz rotacao(double angulo) {
		Matriz r = identidade(3);
		angulo = Math.toRadians(angulo);
		r.set(0, 0, Math.cos(angulo));
		r.set(0, 1, -Math.sin(angulo));
		r.set(1, 0, Math.sin(angulo));
		r.set(1, 1, Math.cos(angulo));

		return r;
	}

	public int getNumLinhas() {
		return numLinhas;
	}

	public int getNumColunas() {
		return numColunas;
	}

}
