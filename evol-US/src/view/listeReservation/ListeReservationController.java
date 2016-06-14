package view.listeReservation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import model.beans.Chambre1;
import model.beans.Client;
import model.beans.Reservation;
import view.composants.reservation.ListeReservation;

public class ListeReservationController implements Initializable {
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private ScrollPane rootSecond;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListeReservation listes = new ListeReservation(getReservations());
		rootSecond.setContent(listes);
		rootSecond.setFitToHeight(true);
		rootSecond.setFitToWidth(true);
	}
	
	/**
	 * Liste de reservation à récupérer dans la base de donnée
	 * @return
	 */
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
		
		
		Reservation reservation5 = new Reservation();
		reservation5.setChambre(chambre2);
		reservation5.setClient(client);
		reservation5.setId(2);
		
		Reservation reservation4 = new Reservation();
		reservation4.setChambre(chambre1);
		reservation4.setClient(client);
		reservation4.setId(1);
		
		Reservation reservation6 = new Reservation();
		reservation6.setChambre(chambre3);
		reservation6.setClient(client);
		reservation6.setId(3);
		
		Reservation reservation7 = new Reservation();
		reservation7.setChambre(chambre3);
		reservation7.setClient(client);
		reservation7.setId(3);
		
		Reservation reservation8 = new Reservation();
		reservation8.setChambre(chambre);
		reservation8.setClient(client);
		reservation8.setId(4);
		
		Reservation reservation9 = new Reservation();
		reservation9.setChambre(chambre2);
		reservation9.setClient(client);
		reservation9.setId(2);
		
		Reservation reservation10 = new Reservation();
		reservation10.setChambre(chambre1);
		reservation10.setClient(client);
		reservation10.setId(1);
		
		Reservation reservation11 = new Reservation();
		reservation11.setChambre(chambre3);
		reservation11.setClient(client);
		reservation11.setId(3);
		
		
		Reservation reservation12 = new Reservation();
		reservation12.setChambre(chambre2);
		reservation12.setClient(client);
		reservation12.setId(2);
		
		Reservation reservation13 = new Reservation();
		reservation13.setChambre(chambre1);
		reservation13.setClient(client);
		reservation13.setId(1);
		
		Reservation reservation15 = new Reservation();
		reservation15.setChambre(chambre3);
		reservation15.setClient(client);
		reservation15.setId(3);
		
		Reservation reservation14 = new Reservation();
		reservation14.setChambre(chambre3);
		reservation14.setClient(client);
		reservation14.setId(3);
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(reservation);
		reservations.add(reservation1);
		reservations.add(reservation2);
		reservations.add(reservation3);
		reservations.add(reservation4);
		reservations.add(reservation5);
		reservations.add(reservation6);
		reservations.add(reservation7);
		
		reservations.add(reservation8);
		reservations.add(reservation9);
		reservations.add(reservation10);
		reservations.add(reservation11);
		reservations.add(reservation12);
		reservations.add(reservation13);
		reservations.add(reservation14);
		reservations.add(reservation15);
		
		return reservations;
	}

}
