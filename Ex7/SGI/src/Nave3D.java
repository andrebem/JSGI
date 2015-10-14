
public class Nave3D extends Poligono3D {
	Window window = null;
	
	public Nave3D(Ponto3D centro){
		double f = 10;
		double z = -80;
		Ponto3D topo   = new Ponto3D(centro.getX(), centro.getY()+f*2.0,z);
		Ponto3D infEsq = new Ponto3D(centro.getX()-f,centro.getY()-f,z);
		Ponto3D fundo  = new Ponto3D(centro.getX(),centro.getY()-f*0.5,z);
		Ponto3D infDir = new Ponto3D(centro.getX()+f,centro.getY()-f,z);
		pontos1.add(topo);
		pontos1.add(infEsq);
		pontos1.add(fundo);
		pontos1.add(infDir);
		
		calculaFundo();
	}
	
	public void setWindow(Window w){
		window = w;
	}
	
	public void voe(){
		Ponto3D topo  = pontos1.get(0);
		Ponto3D fundo = pontos1.get(2);
		double x = topo.getX() - fundo.getX();
		double y = topo.getY() - fundo.getY();
		double atenuacao = 0.2;
		x = x * atenuacao;
		y = y * atenuacao;
		
		Matriz t = Matriz.translacao3d(x, y,0);
		aplique(t);
		if (window != null){
			window.aplique(t);
		}
	}
	
	public void gire(double angulo){
		Ponto3D c = this.getCentro();
		Matriz total = Matriz.translacao3d(-c.getX(), -c.getY(), -c.getZ());
		total = total.vezes(Matriz.rotacao3d(angulo));
		total = total.vezes(Matriz.translacao3d(c.getX(), c.getY(), c.getZ()));
		this.aplique(total);
		//if (window != null){
		//	window.aplique(total);
		//}		
	}
}
