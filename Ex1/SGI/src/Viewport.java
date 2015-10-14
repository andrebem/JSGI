
public interface Viewport {

	public void desenharLinha(Ponto2D p1, Ponto2D p2);

	public Ponto2D getMin();

	public Ponto2D getMax();

	public Ponto2D getTransformada(Ponto2D p, Window w);
}