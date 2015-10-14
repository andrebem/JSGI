
public interface ObjetoGrafico {
	public abstract void desenhe(Window w, JavaViewport vp);
	public abstract void aplique(Matriz m);
	public abstract Ponto2D getCentro();
}
