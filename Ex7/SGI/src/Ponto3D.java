import java.security.InvalidParameterException;


public class Ponto3D {	
	private Matriz m = new Matriz(1,4);
	public Ponto3D(){
		m.set(0,3,1);
	}
	
	public Ponto3D(double x, double y, double z){
		m.set(0,0,x);
		m.set(0,1,y);
		m.set(0,2,z);
		m.set(0,3,1);
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

	public double getZ() {
		return m.get(0, 2);
	}

	public void setZ(double z) {
		m.set(0, 2, z);
	}	
	
	public Ponto3D vezes(Matriz m2) {
		if (m2.getNumLinhas()!=4 ||m2.getNumColunas()!=4){
			throw new InvalidParameterException();
		}
		Matriz result = this.m.vezes(m2);
		Ponto3D p = new Ponto3D(result.get(0, 0), result.get(0,1), result.get(0,2));
		return p;
	}

	public void print() {
		m.print();
	}


}
