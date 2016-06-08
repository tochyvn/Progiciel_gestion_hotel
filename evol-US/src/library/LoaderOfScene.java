package library;

import java.io.IOException;

import application.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class LoaderOfScene {

	public LoaderOfScene() {
		
	}
	
	/**
	 * Charger une ressource physique sous forme de scene
	 * @param path le chemin du fichier .fxml correspondant � la scene
	 * @param typeLayout un entier reprentant le type de layout de la scene
	 * 0 pour le BorderPane
	 * 1 Pour le AnchorPane
	 * 2 Pour du GridPane
	 * @return retourne la scene qui a �t� charg�e
	 */
	public static Scene loadScene(String path, int typeLayout) {
		Scene scene = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApplication.class.getResource(path));
		Parent rootLayout;
		try {
			rootLayout = null;
			switch (typeLayout) {
			case 0:
				rootLayout = (BorderPane)loader.load();
				break;
				
			case 1:
				rootLayout = (AnchorPane)loader.load();
				break;
				
			case 2:
				rootLayout = (GridPane)loader.load();
				break;
			}
			scene = new Scene(rootLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return scene;
	}
	
	public static Parent loadParent(String path, int typeLayout) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApplication.class.getResource(path));
		Parent rootLayout = null;
		try {
			switch (typeLayout) {
			case 0:
				rootLayout = (BorderPane)loader.load();
				break;
			case 1:
				rootLayout = (AnchorPane)loader.load();
				break;
			case 2:
				rootLayout = (GridPane)loader.load();
				break;
			}
		} catch (IOException e) {
			System.out.println("Erreur du chargement du FXML");
			e.printStackTrace();
		}
		
		return rootLayout;
	}

}
