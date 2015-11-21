package org.cesusc.br.lp3;

import java.awt.Color;

public abstract class ObjetoGrafico {
	protected Color cor;

	public abstract void desenhe(Window w, Viewport vp);

	public abstract void aplique(Matriz m);

	public abstract Ponto2D getCentro();

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}
}
