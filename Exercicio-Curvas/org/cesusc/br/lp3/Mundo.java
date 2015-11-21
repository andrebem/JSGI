package org.cesusc.br.lp3;

import java.awt.Color;
import java.util.ArrayList;

public class Mundo {
	Nave2D nave;
	Inimigo inimigo;
	ArrayList<ObjetoGrafico> objetos;
	ArrayList<Asteroide> asteroides;

	Mundo() {
		nave = new Nave2D(new Ponto2D(0, 0));
		nave.setCor(Color.RED);

		Linha2D eixoX = new Linha2D(new Ponto2D(-500, 0), new Ponto2D(500, 0));
		Linha2D eixoY = new Linha2D(new Ponto2D(0, -500), new Ponto2D(0, 500));
		eixoX.setCor(Color.BLUE);
		eixoY.setCor(Color.BLUE);
		objetos = new ArrayList<ObjetoGrafico>();
		objetos.add(eixoX);
		objetos.add(eixoY);

		int numAsteroides = 50;
		asteroides = new ArrayList<Asteroide>();

		for (int i = 0; i < numAsteroides; ++i) {
			double x = (Math.random() - 0.5) * 2000;
			double y = (Math.random() - 0.5) * 2000;

			Asteroide a = new Asteroide(new Ponto2D(x, y));
			a.setCor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
			asteroides.add(a);
		}

		inimigo = new Inimigo(new Ponto2D(200, -200), nave);
	}

	public void desenhe(Window w, Viewport vp) {
		nave.desenhe(w, vp);
		inimigo.desenhe(w, vp);
		for (ObjetoGrafico o : objetos) {
			o.desenhe(w, vp);
		}
		for (Asteroide a : asteroides) {
			a.desenhe(w, vp);
		}
	}

	public Nave2D getNave() {
		return nave;
	}

	public void addObjeto(ObjetoGrafico o) {
		objetos.add(o);
	}

	public void atualize() {
		nave.voe();
		inimigo.voe();
		for (Asteroide a : asteroides) {
			a.voe();
		}
	}
}
