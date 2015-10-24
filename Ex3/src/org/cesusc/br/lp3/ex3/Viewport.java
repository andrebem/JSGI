package org.cesusc.br.lp3.ex3;

public interface Viewport {
	public abstract void desenhaLinha(Ponto2D p1, Ponto2D p2);

	public abstract Ponto2D getMin();

	public abstract Ponto2D getMax();
}