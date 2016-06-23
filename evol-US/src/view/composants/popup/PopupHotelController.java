package view.composants.popup;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import controller.ClientManager;
import controller.ReservationManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.beans.Client;
import model.beans.Reservation;
import model.exception.CreateObjectException;
import view.composants.alerte.AlertConfirmation;
import view.composants.alerte.AlertError;
import view.composants.chambre.ListRoom;

public class PopupHotelController implements Initializable {
	
	private ObservableList<Client> clients;
	
	@FXML
	private ComboBox<Client> cmbClient;
	
	@FXML
	private DatePicker depart;
	
	@FXML
	private DatePicker arrivee;
	
	@FXML
	private TextField txtChambre;
	
	@FXML
	private ComboBox<String> cmbStatut;

	public PopupHotelController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		String pattern = "yyyy-MM-dd";

		depart.setPromptText(pattern.toLowerCase());
		arrivee.setPromptText(pattern.toLowerCase());
		
		depart.setConverter(new StringConverter<LocalDate>() {
		     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		     @Override 
		     public String toString(LocalDate date) {
		         if (date != null) {
		             return dateFormatter.format(date);
		         } else {
		             return "";
		         }
		     }

		     @Override 
		     public LocalDate fromString(String string) {
		         if (string != null && !string.isEmpty()) {
		             return LocalDate.parse(string, dateFormatter);
		         } else {
		             return null;
		         }
		     }
		 });
		
		arrivee.setConverter(new StringConverter<LocalDate>() {
		     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		     @Override 
		     public String toString(LocalDate date) {
		         if (date != null) {
		             return dateFormatter.format(date);
		         } else {
		             return "";
		         }
		     }

		     @Override 
		     public LocalDate fromString(String string) {
		         if (string != null && !string.isEmpty()) {
		             return LocalDate.parse(string, dateFormatter);
		         } else {
		             return null;
		         }
		     }
		 });
		
		ObservableList<String> status = FXCollections.observableArrayList();
		status.addAll(new String("EXPIREE"), new String("EN_COURS"), new String("ANNULEE"));
		cmbStatut.setItems(status);
		cmbStatut.getSelectionModel().select(1);
		
		clients = FXCollections.observableArrayList();
		ClientManager.getInstance().findAll(clients);
		cmbClient.setItems(clients);
		
		txtChambre.setText(ListRoom.roomSelected+"");
	}
	
	@FXML
	private void create() {
		Reservation reservation = null;
		int status = 0;
		try {
			reservation = new Reservation(depart.getValue(),
					arrivee.getValue(),
					ListRoom.roomSelected,
					cmbClient.getSelectionModel().getSelectedItem()
					);
			 status = ReservationManager.getInstance().create(reservation);
		} catch (CreateObjectException e) {
			// TODO Auto-generated catch block
			e.showError();
		}
		

		if (status == 1) {
			AlertConfirmation alert = new AlertConfirmation("Confirmation de la reservation", "Votre reservation à bien été efféctué");
			alert.showAndWait();
		}else {
			AlertError alert = new AlertError("Echec de reservation", "Votre reservation a échoué, veillez reesayez plustard");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void update() {
		
	}
	
	@FXML
	private void delete() {
		
	}

}
