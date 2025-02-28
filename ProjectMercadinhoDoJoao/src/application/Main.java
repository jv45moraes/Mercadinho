package application;


import java.io.IOException;

import Util.cpfValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	
	private static Stage stage;
	private static Scene login;
	private static Scene main;
	private static Scene cliente;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			primaryStage.setTitle("Mercadinho - Login");
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/View/viewlogin.fxml"));
			login = new Scene(fxmlLogin);
			
//			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/View/viewMain.fxml"));
//			main = new Scene(fxmlMain);
			
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Icons/IconMercado.png")));

			primaryStage.setScene(login);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}		
			
	public static void changeScreen(String tela) {
		if(tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
			stage.setTitle("Mercadinho - Menu principal");
		}else if(tela.equals("login")) {
			stage.setScene(login);
			stage.centerOnScreen();
			stage.setTitle("Mercadinho - Login");
		}
	}	
	
	
	
	public static void TelaHome() throws IOException {
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/View/viewMain.fxml"));
		Parent TelaHome = fxmlHome.load();
		main = new Scene(TelaHome);
		stage.setTitle("Mercadinho - Menu principal");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	public static void TelaCliente() throws IOException {
		FXMLLoader fxmlCliente = new FXMLLoader();
		fxmlCliente.setLocation(Main.class.getResource("/View/viewCliente.fxml"));
		Parent TelaCliente = fxmlCliente.load();
		cliente = new Scene(TelaCliente);
		stage.setTitle("Mercadinho - Relatorio de Clientes");
		stage.setScene(cliente);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	
	private static Stage cadCliente;
	public static void TelaCadastroCliente() throws IOException { 
		FXMLLoader fxmlCadastroCliente = new FXMLLoader(); 
		fxmlCadastroCliente.setLocation(Main.class.getResource("/View/viewCadastroCliente.fxml")); 
		Parent cadastroCliente = fxmlCadastroCliente.load(); 
		Scene scene2 = new Scene(cadastroCliente); 
		
		cadCliente = new Stage(); 
		cadCliente.setTitle("Cadastro/Edição de Cliente - Mercadinho do João"); 
		cadCliente.initModality(Modality.WINDOW_MODAL); 
		cadCliente.setScene(scene2);	
		cadCliente.centerOnScreen();	
		cadCliente.showAndWait(); 	
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		launch(args);
	}
}
