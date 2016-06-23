package view.restaurant.header;

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

public class HeaderRestaurantController implements Initializable {
	
	@FXML
	private Label stock;
	
	@FXML
	private Label reservation;
	
	
	private Parent root;

	public HeaderRestaurantController() {
		root = MainApplication.primaryStage.getScene().getRoot();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		reservation.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				reservation.setCursor(Cursor.HAND);
			}
		});
		
		stock.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				stock.setCursor(Cursor.HAND);
			}
		});
	}
	
	@FXML
	private void showStock() {
		this.desactivateStyle();
		stock.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.STOCK_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	private void showReservation() {
		this.desactivateStyle();
		reservation.setStyle("-fx-background-color: white");
		Parent scene = LoaderOfScene.loadParent(ViewInterfaceConstante.ADD_RESERVATION_VIEW, 1);
		((BorderPane)root).setCenter(scene);
		DoubleProperty opacity = scene.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	private void desactivateStyle() {
		stock.setStyle("-fx-background-color:  #4CAF50;");
		reservation.setStyle("-fx-background-color:  #4CAF50;");
	}

}
