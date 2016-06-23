package view.listeReservation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.ReservationManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import model.beans.Chambre;
import model.beans.Client;
import model.beans.Reservation;
import view.composants.reservation.ListeTable;

public class ListeReservationController implements Initializable {
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private ScrollPane rootSecond;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListeTable listes = new ListeTable(ReservationManager.getInstance().findAll());
		rootSecond.setContent(listes);
		rootSecond.setFitToHeight(true);
		rootSecond.setFitToWidth(true);
	}
	

}
