
public final class Linha2D implements Desenhavel {
	private Ponto2D p1;
	private Ponto2D p2;

	public Linha2D(Ponto2D p1, Ponto2D p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void desenhar(Window w, Viewport vp) {
		Ponto2D newP1 = JavaViewport.transformada(this.p1, w, vp);
		Ponto2D newP2 = JavaViewport.transformada(this.p2, w, vp);
		
		vp.desenharLinha(newP1, newP2);
	}

}
