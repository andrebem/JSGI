
public class Linha3D extends ObjetoGrafico {

	private Ponto3D p1;
	private Ponto3D p2;

	public Linha3D(Ponto3D p1, Ponto3D p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void desenhe(Window w, JavaViewport vp) {
		Ponto3D newP1 = JavaViewport.transformada(this.p1, w, vp);
		Ponto3D newP2 = JavaViewport.transformada(this.p2, w, vp);
		
		vp.setCor(cor);
		vp.desenhaLinha(newP1, newP2);
	}

	public void aplique(Matriz m) {
		p1 = p1.vezes(m);
		p2 = p2.vezes(m);
	}
	
	public Ponto3D getCentro(){
		double x = p1.getX() + p2.getX();
		double y = p1.getY() + p2.getY();
		double z = p1.getZ() + p2.getZ();
		return new Ponto3D(x/2, y/2, z/2);
	}
}






