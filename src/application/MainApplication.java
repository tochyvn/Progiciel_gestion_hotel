package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.ViewInterface;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApplication extends Application {
	
	private BorderPane rootLayout;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("GESTION HOTELIERE");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setWidth(1500);
			primaryStage.setHeight(600);	
			this.initRoot();
			this.loadCustomerOverview();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void initRoot() {
		//Chargement du template principale faisant de scène du stage
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(ViewInterface.ROOT_VIEW));
			this.rootLayout = (BorderPane)loader.load();
			Scene scene = new Scene(rootLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch (IOException e) {
			System.out.println("erreur de chargement du fichier .fxml");
			//e.printStackTrace();
		}
	}
	
	public void loadCustomerOverview() {
		//Integration centré dans la scène
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(ViewInterface.CONNEXION_VIEW));
			AnchorPane customerOverview = (AnchorPane)loader.load();
			this.rootLayout.setCenter(customerOverview);
		} catch (IOException e) {
			System.out.println("erreur de chargement du fichier .fxml");
			e.printStackTrace();
		}
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void addClient() {
		
	}
	
}
