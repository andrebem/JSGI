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
		// Esse método deve recalcular a matriz de CPP da Window
		// essa matriz é uma matriz de transformação que faz uma
		// translação e uma rotação. A translação leva a Window ao
		// centro do mundo, e a rotação a deixa alinhada com o eixo Y
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
	public void aplicar(Matriz m) {
		super.aplicar(m);
		this.min = pontos.get(0);
		this.max = pontos.get(2);
		recalculeCPP();
	}
}
