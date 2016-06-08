package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainApplication extends Application {
	
	private BorderPane rootLayout;
	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			MainApplication.primaryStage = primaryStage;
			MainApplication.primaryStage.setTitle("GESTION HOTELIERE");
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
		rootLayout = (BorderPane) LoaderOfScene.loadParent(ViewInterfaceConstante.ROOT_VIEW, 0);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void loadCustomerOverview() {
		//Integration centré dans la scène
		Parent customerOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.CONNEXION_VIEW, 1);
		rootLayout.setCenter(customerOverview);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void addClient() {
		
	}
	
}
