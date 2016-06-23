package view.statistique.header;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import library.Animation;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class HeaderStatistiqueController implements Initializable {
	
	@FXML
	private Button restaurant;
	
	@FXML
	private Button hebergement;
	
	@FXML
	private Button reception;
	
	@FXML
	private Button maintenance;
	
	
	private Parent root;

	public HeaderStatistiqueController() {
		root = MainApplication.primaryStage.getScene().getRoot();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		restaurant.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				restaurant.setCursor(Cursor.HAND);
			}
		});
		
		maintenance.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				maintenance.setCursor(Cursor.HAND);
			}
		});

		reception.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				reception.setCursor(Cursor.HAND);
			}
		});
		
		hebergement.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				hebergement.setCursor(Cursor.HAND);
			}
		});

	}
	
	@FXML
	private void showMaintenance() {
		this.desactivateStyle();
		maintenance.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.MAINTENANCE_STATISTIQUE, 2);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	private void showRestaurant() {
		this.desactivateStyle();
		restaurant.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.RESTAURANT_STATISTIQUE, 2);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void showReception() {
		this.desactivateStyle();
		reception.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.RECEPTION_STATISTIQUE, 2);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	private void showHebergement() {
		this.desactivateStyle();
		hebergement.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.HEBERGEMENT_STATISTIQUE, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	private void desactivateStyle() {
		restaurant.setStyle("-fx-background-color:  #4CAF50;");
		hebergement.setStyle("-fx-background-color:  #4CAF50;");
		maintenance.setStyle("-fx-background-color:  #4CAF50;");
		reception.setStyle("-fx-background-color:  #4CAF50;");
	}
	
	

}
