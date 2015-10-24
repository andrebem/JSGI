package org.cesusc.br.lp3.ex3;

import java.security.InvalidParameterException;

public class Ponto2D {	
	private Matriz m = new Matriz(1,3);
	
	public Ponto2D(){
	}
	
	public Ponto2D(double x, double y){
		m.set(0,0,x);
		m.set(0,1,y);
		m.set(0,2,1);
	}

	public double getX() {
		return m.get(0, 0);
	}

	public void setX(double x) {
		m.set(0,0,x);
	}

	public double getY() {
		return m.get(0, 1);
	}

	public void setY(double y) {
		m.set(0, 1, y);
	}

	public Ponto2D transformar(Matriz m2) {
		if (m2.getNumLinhas()!=3 ||m2.getNumColunas()!=3){
			throw new InvalidParameterException();
		}
		
		Matriz result = this.m.multiplicar(m2);
		Ponto2D p = new Ponto2D(result.get(0, 0), result.get(0,1));
		
		return p;
	}

	public void print() {
		m.print();
	}

}
