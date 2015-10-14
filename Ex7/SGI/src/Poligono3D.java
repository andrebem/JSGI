import java.util.ArrayList;


public class Poligono3D extends ObjetoGrafico {
	protected ArrayList<Ponto3D> pontos1;
	protected ArrayList<Ponto3D> pontos2;
	static final double dist = -5;
	
	public Poligono3D(){
		this.pontos1 = new ArrayList<Ponto3D>();
		this.pontos2 = new ArrayList<Ponto3D>();
	}
	
	public Poligono3D(ArrayList<Ponto3D> pontos){
		this.pontos1 = new ArrayList<Ponto3D>(pontos);
	}
	
	void calculaFundo(){
		// TODO! Essa funcao deve popular o arraylist "pontos2",
		// com pontos que sao copias dos pontos de "pontos1", mas 
		// com valor de "z" incrementado de "dist".
	}
	
	@Override
	public void desenhe(Window w, JavaViewport vp) {
		if (pontos1.size()<2){
			return;
		}
		
		vp.setCor(cor);
		for (int i = 0; i < pontos1.size(); ++i){
			Ponto3D p1 = pontos1.get(i);
			Ponto3D p2 = pontos1.get((i+1)%pontos1.size());

			Linha3D l = new Linha3D(p1,p2);
			l.desenhe(w, vp);
		}
		// TODO! Desenhe também o polígono de pontos2,
		// bem como as ligações entre os polígonos.
	}

	@Override
	public void aplique(Matriz m) {
		for (int i = 0; i < pontos1.size(); ++i){
			Ponto3D p = pontos1.get(i).vezes(m);
			pontos1.set(i, p);
		}
		
		for (int i = 0; i < pontos2.size(); ++i){
			Ponto3D p2 = pontos2.get(i).vezes(m);
			pontos2.set(i, p2);			
		}		
	}

	@Override
	public Ponto3D getCentro() {
		double somaX = 0.0;
		double somaY = 0.0;
		double somaZ = 0.0;
		for (int i = 0; i < pontos1.size(); ++i){
			Ponto3D p = pontos1.get(i);
			somaX += p.getX();
			somaY += p.getY();
			somaZ += p.getZ();
		}
		for (int i = 0; i < pontos2.size(); ++i){
			Ponto3D p = pontos2.get(i);
			somaX += p.getX();
			somaY += p.getY();
			somaZ += p.getZ();
		}		
		return new Ponto3D(somaX/(pontos1.size()+pontos2.size()), somaY/(pontos1.size()+pontos2.size()), somaZ/(pontos1.size()+pontos2.size()));
	}

}
