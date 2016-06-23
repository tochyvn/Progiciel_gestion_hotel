package view.ajoutReservation;

import java.net.URL;
import java.util.ResourceBundle;

import controller.ChambreManager;
import controller.ClientManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.beans.Chambre;
import model.beans.Client;

public class ModifReservationController implements Initializable {

	@FXML
	private DatePicker debut;
	
	@FXML
	private DatePicker arrivee;
	
	@FXML
	private ComboBox<Client> client;
	
	@FXML
	private ComboBox<Chambre> chambre;
	
	ObservableList<Client> clients;
	ObservableList<Chambre> chambres;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clients = FXCollections.observableArrayList();
		chambres = FXCollections.observableArrayList();
		ClientManager.getInstance().findAll(clients);
		ChambreManager.getInstance().findAll(chambres);
		
		client.setItems(clients);
		chambre.setItems(chambres);
		
	}

}
