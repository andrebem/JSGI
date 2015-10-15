
public interface Desenhavel {
	public void desenhar(Window w, Viewport vp);
	public void aplicar(Matriz m);
	public Ponto2D getCentro();
}
