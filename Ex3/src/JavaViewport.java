import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class JavaViewport extends JPanel implements KeyListener{

	private Graphics2D g2d;
	private Window window;
	private Ponto2D min, max;
	ArrayList<ObjetoGrafico> objetos;
	Linha2D linha;

	public JavaViewport(float largura, float altura, Window w) {
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension((int)largura,(int)altura));
		
		this.window = w;
		this.min = new Ponto2D(0,0);
		this.max = new Ponto2D(largura,altura);
		objetos = new ArrayList<ObjetoGrafico>();
		
		linha = new Linha2D(new Ponto2D(-10,-10), new Ponto2D(10,10));
		objetos.add(linha);
	}

	public void paintComponent(Graphics g) {
	    clear(g);
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.setColor(new Color(1.0f,0.0f,0.0f));
	    this.g2d = g2d;

	    for (ObjetoGrafico obj: objetos){
	    	obj.desenhe(this.window, this);
	    }
	    
	    this.g2d = null;
	  }

	protected void clear(Graphics g) {
		super.paintComponent(g);
	}
	  
	public static Ponto2D transformada(Ponto2D p, Window w, JavaViewport vp){
		//TODO implementar!
		// O objeto "w" possui os dados da Window
		// o objeto "vp" possui os dados da Viewport
		// o objeto "p" é o ponto a ser transformado (retorne um novo ponto).
		
		double x = p.getX();
		double y = p.getY();
		Ponto2D wmin = w.getMin();
		Ponto2D wmax = w.getMax();
		Ponto2D vpmin = vp.getMin();
		Ponto2D vpmax = vp.getMax();
		
		double xvp = (x - wmin.getX())/(wmax.getX() - wmin.getX())*(vpmax.getX() - vpmin.getX());
		double yvp = (1-(y - wmin.getY())/(wmax.getY() - wmin.getY()))*(vpmax.getY() - vpmin.getY());
		return new Ponto2D(xvp,yvp);
	}

	public void desenhaLinha(Ponto2D p1, Ponto2D p2){
		g2d.draw(new Line2D.Double(new Point2D.Double(p1.getX(),p1.getY()), new Point2D.Double(p2.getX(),p2.getY())));
	}

	public static void main(String[] args) {
		float largura = 800, altura = 600;
		Window w = new Window(new Ponto2D(-100,-100), new Ponto2D(100,100));
		JavaViewport content = new JavaViewport(largura, altura, w);

		JFrame frame = new JFrame("JavaCG");
		frame.setLayout(new BorderLayout());

		content.setBackground(new Color(1.0f,1.0f,1.0f));
		frame.setMinimumSize(new Dimension((int)largura, (int)altura));
		frame.setContentPane(content);
		frame.setVisible(true); 
		frame.pack();

		testaMatrizes();
	}
	  
	public static void testaMatrizes(){	
		Matriz ida = Matriz.translacao(-3,2);
		Ponto2D p = new Ponto2D(1,5);
		p.vezes(ida).print();
	}

	public Ponto2D getMin() {
		return min;
	}

	public Ponto2D getMax() {
		return max;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()){
		case KeyEvent.VK_UP: 
			linha.aplique(Matriz.translacao(0,10));
			this.repaint();
			break;
		case KeyEvent.VK_DOWN: 
			linha.aplique(Matriz.translacao(0,-10));
			this.repaint();		
			break;
		case KeyEvent.VK_LEFT: 
			escalone(linha,1.1);
			this.repaint();
			break;
		case KeyEvent.VK_RIGHT: 
			escalone(linha,0.9);
			this.repaint();			
			break;
	}		
	}

	private void escalone(Linha2D linha2, double s) {
		//PASSO 1: Transladar do centro da linha
		Ponto2D c = linha2.getCentro();
		Matriz  ida = Matriz.translacao(-c.getX(), -c.getY());
		//PASSO 2: Escalonamento
		Matriz  esc = Matriz.escalonamento(s, s);
		//PASSO 3: Transladar de volta
		Matriz  volta = Matriz.translacao(c.getX(), c.getY());
		Matriz m = ida.vezes(esc).vezes(volta);
		linha2.aplique(m);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
