
public class Bezier2D extends ObjetoGrafico {
	private Ponto3D p1,p2,p3,p4;
	
	public Bezier2D(Ponto3D p1,Ponto3D p2,Ponto3D p3,Ponto3D p4){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}

	@Override
	public void desenhe(Window w, JavaViewport vp) {
		int numPontos = 1000;
		double passo  = 1.0/numPontos;
		Ponto3D primeiro  = this.p1;
		for(double t = 0.0 + passo; t <= 1.0; t += passo){
			Matriz T = new Matriz(1,4);
			T.set(0, 0, t*t*t);
			T.set(0, 1, t*t);
			T.set(0, 2, t);
			T.set(0, 3, 1);
			
			Matriz Mb = new Matriz(4,4);
			Mb.set(0, 0, -1);
			Mb.set(0, 1, 3);
			Mb.set(0, 2, -3);
			Mb.set(0, 3, 1);
			Mb.set(1, 0, 3);
			Mb.set(1, 1, -6);
			Mb.set(1, 2, 3);
			Mb.set(2, 0, -3);
			Mb.set(2, 1, 3);
			Mb.set(3, 0, 1);
			
			Matriz Gb = new Matriz(4,2);
			Gb.set(0, 0, p1.getX());
			Gb.set(0, 1, p1.getY());

			Gb.set(1, 0, p2.getX());
			Gb.set(1, 1, p2.getY());

			Gb.set(2, 0, p3.getX());
			Gb.set(2, 1, p3.getY());

			Gb.set(3, 0, p4.getX());
			Gb.set(3, 1, p4.getY());
			
			Matriz R = T.vezes(Mb).vezes(Gb);
			Ponto3D segundo = new Ponto3D(R.get(0,0),R.get(0,1),0);
			Linha3D l = new Linha3D(primeiro,segundo);
			l.desenhe(w, vp);
			primeiro = segundo;
		}
	}

	@Override
	public void aplique(Matriz m) {
		p1 = p1.vezes(m);
		p2 = p2.vezes(m);
		p3 = p3.vezes(m);
		p4 = p4.vezes(m);
	}

	@Override
	public Ponto3D getCentro() {
		// TODO Auto-generated method stub
		return null;
	}

}
