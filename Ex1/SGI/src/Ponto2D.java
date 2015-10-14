
public class Ponto2D {	
	private Matriz m = new Matriz(1,2);
	public Ponto2D(){
	}
	
	public Ponto2D(double x, double y){
		m.set(0,0,x);
		m.set(0,1,y);
	}

	public double getX() {
		return m.get(0, 0);
	}

	public void setX(double x) {
		m.set(0,0,x);
	}

	public double getY() {
		return m.get(0, 1);
	}

	public void setY(double y) {
		m.set(0, 1, y);
	}

}
