
public class Inimigo extends Poligono3D {
	Nave3D nave;
	public Inimigo(Ponto3D c, Nave3D nave){
		this.nave = nave;
		double f = 30.0;
		Ponto3D[] ptos = new Ponto3D[6];
		ptos[0] = new Ponto3D(c.getX()-f,c.getY(),c.getZ());
		ptos[1] = new Ponto3D(c.getX()-f,c.getY()+f,c.getZ());
		ptos[2] = new Ponto3D(c.getX()+f,c.getY()+f,c.getZ());
		ptos[3] = new Ponto3D(c.getX()+f,c.getY(),c.getZ());	
		ptos[4] = new Ponto3D(c.getX()+2*f,c.getY()-f,c.getZ());
		ptos[5] = new Ponto3D(c.getX()-2*f,c.getY()-f,c.getZ());

		for (Ponto3D p: ptos){
			this.pontos1.add(p);
		}
		
		calculaFundo();
	}
	
	public void voe(){
		Ponto3D c 	  = getCentro();
		Ponto3D cNave = nave.getCentro();
		double xTot   = cNave.getX() - c.getX();
		double yTot   = cNave.getY() - c.getY();
		double hip    = Math.sqrt(xTot*xTot + yTot*yTot);
		double dx = xTot/hip;
		double dy = yTot/hip;
		dx *= 3;
		dy *= 3;
		this.aplique(Matriz.translacao3d(dx, dy,0));
	}
	
}
