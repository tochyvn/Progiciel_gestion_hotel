package view.composants.reservation;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;
import model.beans.Reservation;
import view.ViewInterfaceConstante;
import view.composants.chambre.ListRoom;
import view.composants.popup.Popup;

public class BoxReservation extends VBox {
	
	private Reservation reservation;
	private static String url = "/ressources/img/restaurant.png";

	public BoxReservation() {
		// TODO Auto-generated constructor stub
	}

	public BoxReservation(double spacing) {
		super(spacing);
	}
	
	public BoxReservation(Reservation reservation) {
		this(5.0);
		this.reservation = reservation;
		this.getStyleClass().add("box-room-shadow");
		this.setStyle("-fx-background-color: #4CAF50;");
		/*
		if (reservation.getStatut() == EtatReservation.EN_COURS) {
			this.setStyle("-fx-background-color: #4CAF50;");
		}else {
			this.setStyle("-fx-background-color: #F25333;");
		}
		*/
		Image img = new Image(url);
		ImageView imageView = new ImageView(img);
		Label roomLabel = new Label("Reservation N° : "+reservation.getId());
		Label status = new Label("STATUT : "+reservation.getStatutString());
		Label chambre = new Label("CHAMBRE : "+reservation.getChambre().getIdChambre());
		Label client = new Label("Client : "+reservation.getClient().getNom());
		
		this.getChildren().addAll(imageView, roomLabel, status, chambre, client);
		//Ajouter l'evenement qui se produira au clique
		this.addEvent();
	}
	
	public void addEvent() {
		this.setOnMouseClicked((event) -> {
			
			//On recupï¿½re la BoxRoom sur laquelle l'on a cliquï¿½
			BoxReservation boxReservation = (BoxReservation) event.getSource();
			//On affecte cette chambre ï¿½ la variable statique afin de pouvoir la rï¿½cupï¿½rer dans la Popup
			ListeReservation.reservationSelected = boxReservation.reservation;
			System.out.println(reservation);
			
			//if (ListeReservation.reservationSelected.getStatut() == EtatReservation.EN_COURS) {
				Scene scene = Popup.loadScene(ViewInterfaceConstante.UPDATE_RESERVATION_VIEW, 1);
				//System.out.println(event.getSource());
				Popup popup = new Popup(scene);
				popup.setTitle("Modifier ma reservation");
				popup.initOwner((((Node) event.getSource()).getScene()).getWindow());
				
				//Definir une action ï¿½ la fermeture de la popup
				popup.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						System.out.println("Mettre la variable statique de chambre Ã  NULL");
						ListRoom.roomSelected = null;
					}
				});
				popup.showAndWait();
			//}
			
		});
		
		//Changer le curseur de la souris au survol d'une chambre BoxRoom
		this.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				setCursor(Cursor.HAND);
			}
		});
		
	}
	
	@Override
	public String toString() {
		return this.reservation+"";
	}
	
}
