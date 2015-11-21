package org.cesusc.br.lp3;

public class Window extends Poligono2D {
	private Ponto2D min, max;
	private Matriz matrizCPP;

	public Window(Ponto2D min, Ponto2D max) {
		this.min = min;
		this.max = max;

		Ponto2D p1 = this.min;
		Ponto2D p2 = new Ponto2D(min.getX(), max.getY());
		Ponto2D p3 = this.max;
		Ponto2D p4 = new Ponto2D(max.getX(), min.getY());

		this.pontos.add(p1);
		this.pontos.add(p2);
		this.pontos.add(p3);
		this.pontos.add(p4);

		recalculeCPP();
	}

	private void recalculeCPP() {
		Ponto2D c = getCentro();
		Matriz ida = Matriz.translacao(-c.getX(), -c.getY());

		// angle of 2 relative to 1= atan2(v2.y,v2.x) - atan2(v1.y,v1.x)
		double v1x = 0;
		double v1y = 1;
		double v2x = pontos.get(1).getX() - pontos.get(0).getX();
		double v2y = pontos.get(1).getY() - pontos.get(0).getY();
		double angulo = Math.toDegrees(Math.atan2(v2y, v2x) - Math.atan2(v1y, v1x));

		Matriz rot = Matriz.rotacao(angulo);
		matrizCPP = ida.vezes(rot);
	}

	public Ponto2D transformeParaCPP(Ponto2D p) {
		return p.vezes(matrizCPP);
	}

	public Ponto2D getMin() {
		return min;
	}

	public Ponto2D getMinCPP() {
		return min.vezes(matrizCPP);
	}

	public void setMin(Ponto2D min) {
		this.min = min;
	}

	public Ponto2D getMax() {
		return max;
	}

	public Ponto2D getMaxCPP() {
		return max.vezes(matrizCPP);
	}

	public void setMax(Ponto2D max) {
		this.max = max;
	}

	@Override
	public void aplique(Matriz m) {
		super.aplique(m);
		this.min = pontos.get(0);
		this.max = pontos.get(2);
		recalculeCPP();
	}
}
