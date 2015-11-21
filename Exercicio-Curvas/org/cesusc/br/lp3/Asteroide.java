package org.cesusc.br.lp3;

public class Asteroide extends Poligono2D {
	double dx = 0.0;
	double dy = 0.0;
	double dA = 0.0;

	public Asteroide(Ponto2D centro) {
		double x = 40;
		double y = 40;

		Ponto2D p1 = new Ponto2D(centro.getX(), centro.getY() + y);
		Ponto2D p2 = new Ponto2D(centro.getX() - x, centro.getY());
		Ponto2D p3 = new Ponto2D(centro.getX() - x, centro.getY() - y);
		Ponto2D p4 = new Ponto2D(centro.getX() + x, centro.getY() - y);
		Ponto2D p5 = new Ponto2D(centro.getX() + x, centro.getY() + y);
		Ponto2D p6 = new Ponto2D(centro.getX(), centro.getY());

		this.pontos.add(p1);
		this.pontos.add(p2);
		this.pontos.add(p3);
		this.pontos.add(p4);
		this.pontos.add(p5);
		this.pontos.add(p6);

		dx = (Math.random() - 0.5) * 2.5;
		dy = (Math.random() - 0.5) * 2.5;

		double angulo = Math.random() * 180;
		Ponto2D c = this.getCentro();
		Matriz total = Matriz.translacao(-c.getX(), -c.getY());
		total = total.vezes(Matriz.rotacao(angulo));
		total = total.vezes(Matriz.translacao(c.getX(), c.getY()));
		this.aplique(total);

		dA = (Math.random() - 0.5) * 6;
	}

	public void voe() {
		Matriz t = Matriz.translacao(dx, dy);
		Ponto2D c = this.getCentro();
		Matriz total = Matriz.translacao(-c.getX(), -c.getY());
		total = total.vezes(Matriz.rotacao(dA));
		total = total.vezes(Matriz.translacao(c.getX(), c.getY()));
		total = total.vezes(t);
		this.aplique(total);
	}

}
