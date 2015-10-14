
public class Window extends Poligono3D{
	private Ponto3D min, max;
	private Matriz  matrizCPP;
	private double d;
	
	public Window(Ponto3D min, Ponto3D max, double d) {
		this.min = min;
		this.max = max;
		this.d = d;
		
		Ponto3D p1 = this.min;
		Ponto3D p2 = new Ponto3D(min.getX(), max.getY(),d);
		Ponto3D p3 = this.max; 
		Ponto3D p4 = new Ponto3D(max.getX(), min.getY(),d);

		this.pontos1.add(p1);
		this.pontos1.add(p2);
		this.pontos1.add(p3);
		this.pontos1.add(p4);
		
	}
	
	public Ponto3D getMin() {
		return min;
	}
	
	public void setMin(Ponto3D min) {
		this.min = min;
	}

	public Ponto3D getMax() {
		return max;
	}

	public void setMax(Ponto3D max) {
		this.max = max;
	}

	public Ponto3D projete(Ponto3D p){
		//TODO: Essa funcao deve calcular a projecao do ponto P sobre esta window,
		// usando as coordenadas do ponto e o valor "d" da propria window.
		double xp = 0.0; //TODO!
		double yp = 0.0; //TODO!
		
		return new Ponto3D(xp,yp,d);
	}
	
	@Override
	public void aplique(Matriz m) {
		super.aplique(m);
		this.min = pontos1.get(0);
		this.max = pontos1.get(2);
	}	
}
