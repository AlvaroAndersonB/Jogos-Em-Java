package br.com.alvaro.jogo.model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationS extends Application {

	int click = 0;
	Button[][] botoes = new Button[3][3];

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane cena = new GridPane();

		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				Button botao = new Button();
				
				Campo campo = new Campo(i, j);
				
				botao.setPrefSize(100, 100);
				
				botao.setOnAction(e -> {
					if (click % 2 == 0 && botao.getText().isEmpty()) {
						botao.setText("O");
						campo.adicionarMarcadoO(campo);
						click++;
						
						if (campo.verificarVencedorencedor("O")) {
							System.out.println("O jogador com O" + " ganhou!");
							primaryStage.close();
						}
						
					} else if (botao.getText().isEmpty()) {
						botao.setText("X");
						campo.adicionarMarcadoX(campo);
						click++;
						if (campo.verificarVencedorencedor("X")) {
							System.out.println("O jogador com X" + " ganhou!");
							primaryStage.close();
						}
						
					}
					if (click == 9) {
						System.out.println("Empate, vocês são ruins");
						primaryStage.close();
					}
				});
				
				botoes[i][j] = botao;
				cena.add(botao, j, i);

				if (click == 9) {
					System.out.println("Empate, vocês são ruins");
					primaryStage.close();
				}
			}
		}
		Scene scene = new Scene(cena, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Jogo da Velha");
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {

		launch(args);

	}

}
