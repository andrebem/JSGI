import java.awt.Color;


public abstract class ObjetoGrafico {
	protected Color cor;
	public abstract void desenhe(Window w, JavaViewport vp);
	public abstract void aplique(Matriz m);
	public abstract Ponto3D getCentro();
	
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
	}
}
