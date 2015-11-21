package org.cesusc.br.lp3;

import java.awt.Color;

public interface Viewport {

	void setCor(Color cor);

	void desenhaLinha(Ponto2D p1, Ponto2D p2);

	Ponto2D getMin();

	Ponto2D getMax();

}