import java.awt.Color;


public abstract class ObjetoDesenhavel {
	protected Color cor;
	public abstract void desenhar(Window w, Viewport vp);
	public abstract void aplicar(Matriz m);
	public abstract Ponto2D getCentro();
	
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
	}
}
