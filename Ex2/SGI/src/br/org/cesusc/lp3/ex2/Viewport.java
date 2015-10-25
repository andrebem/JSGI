package br.org.cesusc.lp3.ex2;

public interface Viewport {

	public abstract void desenharLinha(Ponto2D p1, Ponto2D p2);

	public abstract Ponto2D getMin();

	public abstract Ponto2D getMax();

	public Ponto2D getTransformada(Ponto2D p, Window w, Viewport vp);
}