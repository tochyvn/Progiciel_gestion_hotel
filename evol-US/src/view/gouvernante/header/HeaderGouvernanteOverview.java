package view.gouvernante.header;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApplication;
import javafx.beans.property.DoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class HeaderGouvernanteOverview implements Initializable {
	
	@FXML
	private Label nettoyage;
	
	private Parent root;

	public HeaderGouvernanteOverview() {
		root = MainApplication.primaryStage.getScene().getRoot();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Changer le curseur de la souris au survol d'une chambre BoxRoom
		nettoyage.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				nettoyage.setCursor(Cursor.HAND);
			}
		});
	}
	
	@FXML
	private void showNettoyage() {
		this.desactivateStyle();
		nettoyage.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_GOUVERNANTE, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	private void desactivateStyle() {
		nettoyage.setStyle("-fx-background-color:  #4CAF50;");
	}

}
