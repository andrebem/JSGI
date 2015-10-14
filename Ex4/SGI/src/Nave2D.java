
public class Nave2D extends Poligono2D {
	Window window = null;
	
	public Nave2D(Ponto2D centro){
		double f = 10;
		Ponto2D topo   = new Ponto2D(centro.getX(), centro.getY()+f*2.0);
		Ponto2D infEsq = new Ponto2D(centro.getX()-f,centro.getY()-f);
		Ponto2D fundo  = new Ponto2D(centro.getX(),centro.getY()-f*0.5);
		Ponto2D infDir = new Ponto2D(centro.getX()+f,centro.getY()-f);
		pontos.add(topo);
		pontos.add(infEsq);
		pontos.add(fundo);
		pontos.add(infDir);
	}
	
	public void setWindow(Window w){
		window = w;
	}
	
	public void voe(){
		Ponto2D topo  = pontos.get(0);
		Ponto2D fundo = pontos.get(2);
		double x = topo.getX() - fundo.getX();
		double y = topo.getY() - fundo.getY();
		double atenuacao = 0.2;
		x = x * atenuacao;
		y = y * atenuacao;
		
		Matriz t = Matriz.translacao(x, y);
		aplique(t);
		if (window != null){
			window.aplique(t);
		}
	}
	
	public void gire(double angulo){
		Ponto2D c = this.getCentro();
		Matriz total = Matriz.translacao(-c.getX(), -c.getY());
		total = total.vezes(Matriz.rotacao(angulo));
		total = total.vezes(Matriz.translacao(c.getX(), c.getY()));
		this.aplique(total);
		if (window != null){
			window.aplique(total);
		}		
	}
}
