package org.cesusc.br.lp3;

public class Inimigo extends Poligono2D {
	Nave2D nave;

	public Inimigo(Ponto2D c, Nave2D nave) {
		this.nave = nave;
		double f = 30.0;
		Ponto2D[] ptos = new Ponto2D[6];
		ptos[0] = new Ponto2D(c.getX() - f, c.getY());
		ptos[1] = new Ponto2D(c.getX() - f, c.getY() + f);
		ptos[2] = new Ponto2D(c.getX() + f, c.getY() + f);
		ptos[3] = new Ponto2D(c.getX() + f, c.getY());
		ptos[4] = new Ponto2D(c.getX() + 2 * f, c.getY() - f);
		ptos[5] = new Ponto2D(c.getX() - 2 * f, c.getY() - f);

		for (Ponto2D p : ptos) {
			this.pontos.add(p);
		}
	}

	public void voe() {
		Ponto2D c = getCentro();
		Ponto2D cNave = nave.getCentro();
		double xTot = cNave.getX() - c.getX();
		double yTot = cNave.getY() - c.getY();
		double hip = Math.sqrt(xTot * xTot + yTot * yTot);
		double dx = xTot / hip;
		double dy = yTot / hip;
		dx *= 3;
		dy *= 3;
		this.aplique(Matriz.translacao(dx, dy));
	}

}
