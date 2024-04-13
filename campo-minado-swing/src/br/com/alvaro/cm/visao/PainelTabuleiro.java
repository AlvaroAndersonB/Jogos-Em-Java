package br.com.alvaro.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.alvaro.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservador(e -> {
			SwingUtilities.invokeLater(() -> {

				if (e.isGanhou()) {
					JOptionPane.showConfirmDialog(this, "Ganhou :)");

				} else {
					JOptionPane.showConfirmDialog(this, "Perdeu :(");
				}
				tabuleiro.reiniciar();
			});

		});

	}

}
