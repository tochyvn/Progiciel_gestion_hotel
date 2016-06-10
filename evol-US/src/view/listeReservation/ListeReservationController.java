package view.listeReservation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import model.beans.Chambre1;
import model.beans.Client;
import model.beans.Reservation;
import view.composants.reservation.ListeReservation;

public class ListeReservationController implements Initializable {
	
	@FXML
	private AnchorPane root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListeReservation listes = new ListeReservation(getReservations());
		listes.setPrefSize(1000, 450);
		ScrollPane scrollable = new ScrollPane();
	
		scrollable.autosize();
		scrollable.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollable.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollable.setContent(listes);

		scrollable.setPrefHeight(450);
		scrollable.setPrefWidth(1000);
		
		
		System.out.println(root.getPrefHeight());
		System.out.println(root.getPrefWidth());
		scrollable.setPannable(true);
		root.getChildren().add(scrollable);
		
	}
	
	private ArrayList<Reservation> getReservations() {
		Chambre1 chambre = new Chambre1("300 m2", "0755032386", "2", "2", false, false, false, 250.0);
		Chambre1 chambre1 = new Chambre1("300 m2", "0755032386", "2", "2", false, false, false, 250.0);
		Chambre1 chambre2 = new Chambre1("300 m2", "0755032386", "2", "2", false, false, false, 250.0);
		Chambre1 chambre3 = new Chambre1("300 m2", "0755032386", "2", "2", false, false, false, 250.0);
		
		chambre.setIdChambre(1);	
		chambre1.setIdChambre(2);
		chambre2.setIdChambre(3);	
		chambre3.setIdChambre(4);  
		
		Client client = new Client();
		client.setAdresse("25 rue honnorat");
		client.setNom("tochap");
		client.setPrenom("yvanov");
		
		Reservation reservation = new Reservation();
		reservation.setChambre(chambre);
		reservation.setClient(client);
		reservation.setId(4);
		
		Reservation reservation2 = new Reservation();
		reservation2.setChambre(chambre2);
		reservation2.setClient(client);
		reservation2.setId(2);
		
		Reservation reservation1 = new Reservation();
		reservation1.setChambre(chambre1);
		reservation1.setClient(client);
		reservation1.setId(1);
		
		Reservation reservation3 = new Reservation();
		reservation3.setChambre(chambre3);
		reservation3.setClient(client);
		reservation3.setId(3);
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(reservation);
		reservations.add(reservation1);
		reservations.add(reservation2);
		reservations.add(reservation3);
		
		return reservations;
	}

}
