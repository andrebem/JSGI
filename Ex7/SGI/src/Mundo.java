import java.awt.Color;
import java.util.ArrayList;


public class Mundo {
	Nave3D nave;
	Inimigo inimigo;
	ArrayList<ObjetoGrafico> objetos;
	ArrayList<Asteroide> asteroides;
	
	
	Mundo(){
		nave = new Nave3D(new Ponto3D(0,0,0));
		nave.setCor(Color.RED);
		
		Linha3D eixoX = new Linha3D(new Ponto3D(-500,0,-50), new Ponto3D(500,0,-50));
		Linha3D eixoY = new Linha3D(new Ponto3D(0,-500,-50), new Ponto3D(0,500,-50));
		eixoX.setCor(Color.BLUE);
		eixoY.setCor(Color.BLUE);
		objetos = new ArrayList<ObjetoGrafico>();
		objetos.add(eixoX);
		objetos.add(eixoY);
		
		int numAsteroides = 50;
		asteroides = new ArrayList<Asteroide>();

		for (int i = 0; i < numAsteroides; ++i){
			double x = (Math.random()-0.5)*2000;
			double y = (Math.random()-0.5)*2000;
			
			Asteroide a = new Asteroide(new Ponto3D(x,y,-80));
			a.setCor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			asteroides.add(a);
		}	
		
		inimigo = new Inimigo(new Ponto3D(200,-200,-80),nave);
		
	}
	
	public void desenhe(Window w, JavaViewport vp){
		nave.desenhe(w, vp);
		inimigo.desenhe(w, vp);
		for (ObjetoGrafico o: objetos){
			o.desenhe(w, vp);
		}
		for (Asteroide a: asteroides){
			a.desenhe(w, vp);
		}
	}
	
	public Nave3D getNave() {
		return nave;
	}

	public void addObjeto(ObjetoGrafico o){
		objetos.add(o);
	}
	
	public void atualize(){
		nave.voe();
		inimigo.voe();
		for (Asteroide a: asteroides){
			a.voe();
		}		
	}
}
