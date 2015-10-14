
public class Linha2D extends ObjetoGrafico {

	private Ponto2D p1;
	private Ponto2D p2;

	public Linha2D(Ponto2D p1, Ponto2D p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void desenhe(Window w, JavaViewport vp) {
		Ponto2D newP1 = JavaViewport.transformada(this.p1, w, vp);
		Ponto2D newP2 = JavaViewport.transformada(this.p2, w, vp);
		
		vp.setCor(cor);
		vp.desenhaLinha(newP1, newP2);
	}

	public void aplique(Matriz m) {
		p1 = p1.vezes(m);
		p2 = p2.vezes(m);
	}
	
	public Ponto2D getCentro(){
		double x = p1.getX() + p2.getX();
		double y = p1.getY() + p2.getY();
		return new Ponto2D(x/2, y/2);
	}
}






