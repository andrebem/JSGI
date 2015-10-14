
public class Window {
	public Window(Ponto2D min, Ponto2D max) {
		this.min = min;
		this.max = max;
	}

	private Ponto2D min, max;

	public Ponto2D getMin() {
		return min;
	}

	public void setMin(Ponto2D min) {
		this.min = min;
	}

	public Ponto2D getMax() {
		return max;
	}

	public void setMax(Ponto2D max) {
		this.max = max;
	}
	
}
