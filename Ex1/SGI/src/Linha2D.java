
public class Linha2D implements ObjetoGrafico {

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
		
		vp.desenhaLinha(newP1, newP2);
	}

}
