import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class JavaViewport extends JPanel implements KeyListener{

	private Graphics2D g2d;
	private Window window;
	private Ponto3D min, max;
	Mundo mundo;

	public JavaViewport(float largura, float altura, Window w, Mundo m) {
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension((int)largura,(int)altura));
		
		this.window = w;
		this.mundo = m;
		this.min = new Ponto3D(0,0,0);
		this.max = new Ponto3D(largura,altura,0);

	}

	public void paintComponent(Graphics g) {
	    clear(g);
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.setColor(new Color(1.0f,0.0f,0.0f));
	    this.g2d = g2d;

	    mundo.desenhe(this.window, this);
	    
	    this.g2d = null;
	  }

	protected void clear(Graphics g) {
		super.paintComponent(g);
	}
	  
	public static Ponto3D transformada(Ponto3D p, Window w, JavaViewport vp){
		//TODO implementar!
		// O objeto "w" possui os dados da Window
		// o objeto "vp" possui os dados da Viewport
		// o objeto "p" é o ponto a ser transformado (retorne um novo ponto).
		p = w.projete(p);
		
		double x = p.getX();
		double y = p.getY();
		Ponto3D wmin = w.getMin();
		Ponto3D wmax = w.getMax();
		Ponto3D vpmin = vp.getMin();
		Ponto3D vpmax = vp.getMax();
		
		double xvp = (x - wmin.getX())/(wmax.getX() - wmin.getX())*(vpmax.getX() - vpmin.getX());
		double yvp = (1-(y - wmin.getY())/(wmax.getY() - wmin.getY()))*(vpmax.getY() - vpmin.getY());
		return new Ponto3D(xvp,yvp,0);
	}
	
	public void setCor(Color cor){
		g2d.setColor(cor);
	}

	public void desenhaLinha(Ponto3D p1, Ponto3D p2){
		g2d.draw(new Line2D.Double(new Point2D.Double(p1.getX(),p1.getY()), new Point2D.Double(p2.getX(),p2.getY())));
	}

	public static void main(String[] args) {
		float totLargura = 800, totAltura = 600;
		float largura1 =300, altura1 = 300;
		float largura2 =500, altura2 = 500;
		Mundo mundo = new Mundo();
		double d = -80;
		Window w1 = new Window(new Ponto3D(-200,-200,d), new Ponto3D(200,200,d),d);
		Window w2 = new Window(new Ponto3D(-800,-800,d), new Ponto3D(800,800,d),d);
		JavaViewport mini = new JavaViewport(largura1, altura1, w1, mundo);
		JavaViewport main = new JavaViewport(largura2, altura2, w2, mundo);
		mundo.addObjeto(w1);
		mundo.getNave().setWindow(w1);
		
		JFrame frame = new JFrame("JavaCG");
		frame.setLayout(new BorderLayout());

		mini.setBackground(new Color(1.0f, 1.0f,1.0f));
		mini.setBorder(BorderFactory.createLineBorder(Color.red));
		main.setBackground(new Color(1.0f,1.0f,1.0f));
		main.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JPanel bla = new JPanel();
		bla.setLayout(new GridBagLayout());
		bla.add(mini);
		bla.add(main);
		Timer t = new Timer();
		t.schedule(new TimerAction(mundo, bla), 0, 30);
		
		
		frame.setBackground(new Color(1.0f,1.0f,1.0f));
		frame.setMinimumSize(new Dimension((int)totLargura, (int)totAltura));
		frame.setContentPane(bla);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		testaMatrizes();
	}
	  
	public static void testaMatrizes(){	
		Matriz ida = Matriz.translacao3d(-3,2,0);
		Ponto3D p = new Ponto3D(1,5,0);
		p.vezes(ida).print();
	}

	public Ponto3D getMin() {
		return min;
	}

	public Ponto3D getMax() {
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
			mundo.getNave().voe();
			this.getParent().repaint();
			break;
		case KeyEvent.VK_DOWN: 
			//poligono.aplique(Matriz.translacao(0,-10));
			this.getParent().repaint();
			break;
		case KeyEvent.VK_LEFT: 
			mundo.getNave().gire(10);
			this.getParent().repaint();
			break;
		case KeyEvent.VK_RIGHT: 
			mundo.getNave().gire(-10);
			this.getParent().repaint();
			break;
	}		
	}

	private void escalone(ObjetoGrafico o, double s) {
		//PASSO 1: Transladar do centro da linha
		Ponto3D c = o.getCentro();
		Matriz  ida = Matriz.translacao3d(-c.getX(), -c.getY(), -c.getZ());
		//PASSO 2: Escalonamento
		Matriz  esc = Matriz.escalonamento3d(s, s,s);
		//PASSO 3: Transladar de volta
		Matriz  volta = Matriz.translacao3d(c.getX(), c.getY(), c.getZ());
		Matriz m = ida.vezes(esc).vezes(volta);
		o.aplique(m);
	}
	
	private void rotacione(ObjetoGrafico o, double a) {
		//PASSO 1: Transladar do centro da linha
		Ponto3D c = o.getCentro();
		Matriz  ida = Matriz.translacao3d(-c.getX(), -c.getY(),-c.getZ());
		//PASSO 2: Escalonamento
		Matriz  esc = Matriz.rotacao3d(a);
		//PASSO 3: Transladar de volta
		Matriz  volta = Matriz.translacao3d(c.getX(), c.getY(),c.getZ());
		Matriz m = ida.vezes(esc).vezes(volta);
		o.aplique(m);
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}