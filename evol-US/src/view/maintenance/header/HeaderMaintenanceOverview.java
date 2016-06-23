package view.maintenance.header;

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
import library.Animation;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class HeaderMaintenanceOverview implements Initializable {
	
	@FXML
	private Label encaissement;
	
	@FXML
	private Label planning;
	
	@FXML
	private Label reservation;
	
	@FXML
	private Label service;
	
	private Parent root;

	public HeaderMaintenanceOverview() {
		root = MainApplication.primaryStage.getScene().getRoot();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Changer le curseur de la souris au survol d'une chambre BoxRoom
		encaissement.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				encaissement.setCursor(Cursor.HAND);
			}
		});
		
		reservation.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				reservation.setCursor(Cursor.HAND);
			}
		});
		
		planning.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				planning.setCursor(Cursor.HAND);
			}
		});
		
		service.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				service.setCursor(Cursor.HAND);
			}
		});
	}
	
	@FXML
	private void showPlanning() {
		this.desactivateStyle();
		planning.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.PLANNING_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void showEncaissement() {
		this.desactivateStyle();
		encaissement.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.ENCAISSEMENT_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void showReservation() {
		this.desactivateStyle();
		reservation.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.CHAMBRE_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void showService() {
		this.desactivateStyle();
		service.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.SURMESURE_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	private void desactivateStyle() {
		service.setStyle("-fx-background-color:  #4CAF50;");
		reservation.setStyle("-fx-background-color:  #4CAF50;");
		encaissement.setStyle("-fx-background-color:  #4CAF50;");
		planning.setStyle("-fx-background-color:  #4CAF50;");
	}

}
