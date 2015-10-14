
public class Asteroide extends Poligono3D {
	double dx = 0.0;
	double dy = 0.0;
	double dA = 0.0;
	
	public Asteroide(Ponto3D centro){
		double x = 40;
		double y = 40;

		Ponto3D p1 = new Ponto3D(centro.getX(), centro.getY()+y,centro.getZ());
		Ponto3D p2 = new Ponto3D(centro.getX()-x, centro.getY(),centro.getZ());
		Ponto3D p3 = new Ponto3D(centro.getX()-x, centro.getY()-y,centro.getZ());
		Ponto3D p4 = new Ponto3D(centro.getX()+x, centro.getY()-y,centro.getZ());     
		Ponto3D p5 = new Ponto3D(centro.getX()+x, centro.getY()+y,centro.getZ());     
		Ponto3D p6 = new Ponto3D(centro.getX(), centro.getY(),centro.getZ()); 

		this.pontos1.add(p1);
		this.pontos1.add(p2);
		this.pontos1.add(p3);
		this.pontos1.add(p4);
		this.pontos1.add(p5);
		this.pontos1.add(p6);
		
		calculaFundo();
		       
		dx = (Math.random()-0.5) * 2.5;
		dy = (Math.random()-0.5) * 2.5;
		
		double angulo = Math.random()*180;
		Ponto3D c = this.getCentro();
		Matriz total = Matriz.translacao3d(-c.getX(), -c.getY(),0);
		total = total.vezes(Matriz.rotacao3d(angulo));
		total = total.vezes(Matriz.translacao3d(c.getX(), c.getY(), 0));
		this.aplique(total);
		
		dA = (Math.random()-0.5)*6;
	}

	public void voe() {
		Matriz t = Matriz.translacao3d(dx, dy,0);
		Ponto3D c = this.getCentro();
		Matriz total = Matriz.translacao3d(-c.getX(), -c.getY(), -c.getZ());
		total = total.vezes(Matriz.rotacao3d(dA));
		total = total.vezes(Matriz.translacao3d(c.getX(), c.getY(), c.getZ()));
		total = total.vezes(t);
		this.aplique(total);
	}
	
	
}
