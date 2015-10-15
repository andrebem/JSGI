import java.awt.Color;

public interface Viewport {

	public abstract void setCor(Color cor);

	public abstract void desenhaLinha(Ponto2D p1, Ponto2D p2);

	public abstract Ponto2D getMin();

	public abstract Ponto2D getMax();

}