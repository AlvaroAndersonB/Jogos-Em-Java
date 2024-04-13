package br.com.alvaro.jogo.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private int linha;
	private int coluna;
	static private List<Campo> MarcadosX = new ArrayList<>();
	static private List<Campo> MarcadosO = new ArrayList<>();
	static private List<Campo> Intermediaria = new ArrayList<>();

	public void adicionarMarcadoX(Campo campo) {
		MarcadosX.add(this);
	}

	public void adicionarMarcadoO(Campo campo) {
		MarcadosO.add(this);
	}

	 Campo() {
		super();
	}

	public Campo(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean vencedorPorLinha(String k) {
		int linha0 = 0;
		int linha1 = 0;
		int linha2 = 0;
		if (k == "X") {
			Intermediaria = MarcadosX;
		} else {
			Intermediaria = MarcadosO;
		}
		for (Campo e : Intermediaria) {
			if (e.linha == 0) {
				linha0++;
			} else if (e.linha == 1) {
				linha1++;
			} else {
				linha2++;
			}
		}
		if (linha0 == 3 || linha1 == 3 || linha2 == 3) {
			return true;
		}
		return false;
	}

	public boolean vencedorPorColunas(String k) {
		int coluna0 = 0;
		int coluna1 = 0;
		int coluna2 = 0;
		if (k == "X") {
			Intermediaria = MarcadosX;
		} else {
			Intermediaria = MarcadosO;
		}
		for (Campo campo : Intermediaria) {
			if (campo.coluna == 0) {
				coluna0++;
			} else if (campo.coluna == 1) {
				coluna1++;
			} else {
				coluna2++;
			}
		}
		if (coluna0 == 3 || coluna1 == 3 || coluna2 == 3) {
			return true;
		}
		return false;
	}

	public boolean vencedorPorDiagonal(String k) {
		int diagonal = 0;
		int contraDiagonal = 0;
		if (k == "X") {
			Intermediaria = MarcadosX;
		} else {
			Intermediaria = MarcadosO;
		}

		for (Campo campo : Intermediaria) {
			int deltaColuna = Math.abs(campo.linha - campo.coluna);

			if (deltaColuna == 0) {
				if (campo.linha == 1 & campo.coluna == 1) {
					contraDiagonal++;
				}
				diagonal++;
			} else if (deltaColuna == 2) {
				contraDiagonal++;
			}
		}
		if (diagonal == 3 || contraDiagonal == 3) {
			return true;
		}
		return false;
	}

	public boolean verificarVencedorencedor(String k) {
		if (vencedorPorColunas(k) || vencedorPorLinha(k) || vencedorPorDiagonal(k)) {
			return true;
		} else
			return false;
	}
	
	public boolean empate() {
		if (MarcadosO.size() + MarcadosX.size() > 1) {
			return true;
		} else
			return false;
	}

}
