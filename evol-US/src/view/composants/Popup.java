package view.composants;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Popup extends Stage {
	
	/**
	 * La scene à charger dans la popup
	 */
	private Scene sceneLoaded;
	
	public Popup(Scene scene) {
		super();
		this.setScene(scene);
		this.show();
	}

	public Scene getSceneLoaded() {
		return sceneLoaded;
	}

	public void setSceneLoaded(Scene sceneLoaded) {
		this.sceneLoaded = sceneLoaded;
	}
	
	public static Scene loadScene(String path) {
		
		return null;
	}
	
	

}
