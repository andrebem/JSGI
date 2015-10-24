package org.cesusc.br.lp3.ex3;

public class Linha2D implements Desenhavel {

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
		
		vp.desenhaLinha(newP1, newP2);
	}

	public void aplicar(Matriz m) {
		p1 = p1.transformar(m);
		p2 = p2.transformar(m);
	}
	
	public Ponto2D getCentro(){
		double x = p1.getX() + p2.getX();
		double y = p1.getY() + p2.getY();
		return new Ponto2D(x/2, y/2);
	}
}






