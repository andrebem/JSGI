package org.cesusc.br.lp3;

import java.util.ArrayList;

public class Poligono2D extends ObjetoGrafico {
	protected ArrayList<Ponto2D> pontos;

	public Poligono2D() {
		this.pontos = new ArrayList<Ponto2D>();
	}

	public Poligono2D(ArrayList<Ponto2D> pontos2) {
		this.pontos = new ArrayList<Ponto2D>(pontos2);
	}

	@Override
	public void desenhe(Window w, Viewport vp) {
		if (pontos.size() < 2) {
			return;
		}

		vp.setCor(cor);
		for (int i = 0; i < pontos.size(); ++i) {
			Ponto2D p1 = pontos.get(i);
			Ponto2D p2 = pontos.get((i + 1) % pontos.size());

			Linha2D l = new Linha2D(p1, p2);
			l.desenhe(w, vp);
		}
	}

	@Override
	public void aplique(Matriz m) {
		for (int i = 0; i < pontos.size(); ++i) {
			Ponto2D p = pontos.get(i).vezes(m);
			pontos.set(i, p);
		}
	}

	@Override
	public Ponto2D getCentro() {
		double somaX = 0.0;
		double somaY = 0.0;
		for (int i = 0; i < pontos.size(); ++i) {
			Ponto2D p = pontos.get(i);
			somaX += p.getX();
			somaY += p.getY();
		}
		return new Ponto2D(somaX / pontos.size(), somaY / pontos.size());
	}

}
