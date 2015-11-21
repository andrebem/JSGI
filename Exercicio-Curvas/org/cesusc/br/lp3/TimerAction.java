package org.cesusc.br.lp3;

import java.util.TimerTask;

import javax.swing.JPanel;

class TimerAction extends TimerTask {
	Mundo mundo;
	JPanel tela;

	public TimerAction(Mundo mundo, JPanel tela) {
		this.mundo = mundo;
		this.tela = tela;
	}

	public void run() {
		mundo.atualize();
		tela.repaint();
	}
}