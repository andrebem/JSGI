package br.org.cesusc.lp3.ex2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaViewport extends JPanel implements KeyListener, Viewport {
	private Graphics2D g2d;
	private Window window;
	private Ponto2D min, max;
	ArrayList<Desenhavel> objetos;

	public JavaViewport(float largura, float altura, Window w) {
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension((int) largura, (int) altura));

		this.window = w;
		this.min = new Ponto2D(0, 0);
		this.max = new Ponto2D(largura, altura);
		objetos = new ArrayList<Desenhavel>();

		Linha2D linha = new Linha2D(new Ponto2D(-100, -100), new Ponto2D(100,
				100));
		objetos.add(linha);
	}

	public void paintComponent(Graphics g) {
		clear(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(1.0f, 0.0f, 0.0f));
		this.g2d = g2d;

		for (Desenhavel obj : objetos) {
			obj.desenhar(this.window, this);
		}

		this.g2d = null;
	}

	protected void clear(Graphics g) {
		super.paintComponent(g);
	}

	public Ponto2D getTransformada(Ponto2D p, Window w, Viewport vp) {
		// TODO implementar!
		// O objeto "w" possui os dados da Window
		// o objeto "vp" possui os dados da Viewport
		// o objeto "p" é o ponto a ser transformado (retorne um novo ponto).

		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Viewport#desenhaLinha(Ponto2D, Ponto2D)
	 */
	@Override
	public void desenharLinha(Ponto2D p1, Ponto2D p2) {
		g2d.draw(new Line2D.Double(new Point2D.Double(p1.getX(), p1.getY()),
				new Point2D.Double(p2.getX(), p2.getY())));
	}

	public static void main(String[] args) {
		float largura = 800, altura = 600;
		Window w = new Window(new Ponto2D(-100, -100), new Ponto2D(100, 100));
		JavaViewport content = new JavaViewport(largura, altura, w);

		JFrame frame = new JFrame("JavaCG");
		frame.setLayout(new BorderLayout());

		content.setBackground(new Color(1.0f, 1.0f, 1.0f));
		frame.setMinimumSize(new Dimension((int) largura, (int) altura));
		frame.setContentPane(content);
		frame.setVisible(true);
		frame.pack();

		testarMatrizes();
	}

	public static void testarMatrizes() {
		Matriz a = new Matriz(1, 3);
		Matriz b = new Matriz(3, 1);
		for (int i = 0; i < 3; i++) {
			a.set(0, i, 1);
			b.set(i, 0, 2);
		}
		Matriz c = a.multiplicar(b);
		a.print();
		System.out.println();
		b.print();
		System.out.println();
		c.print();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Viewport#getMin()
	 */
	@Override
	public Ponto2D getMin() {
		return min;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Viewport#getMax()
	 */
	@Override
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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_DOWN:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}