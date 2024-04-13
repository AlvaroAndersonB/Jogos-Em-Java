package br.com.alvaro.cm.visao;

import javax.swing.JFrame;

import br.com.alvaro.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);
		add(new PainelTabuleiro(tabuleiro));
		setTitle("Campo Minado");
		setSize(690, 438);
		setLocale(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new TelaPrincipal();

	}

}
