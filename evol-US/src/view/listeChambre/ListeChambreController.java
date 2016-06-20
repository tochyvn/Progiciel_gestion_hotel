package view.listeChambre;

import java.net.URL;
import java.util.ResourceBundle;

import controller.ChambreManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import model.beans.Chambre;
import model.beans.EtatChambre;
import view.composants.chambre.ListRoom;

public class ListeChambreController implements Initializable {
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private ScrollPane rootSecond;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ListRoom listeChambres = new ListRoom(ChambreManager.getInstance().findAll1());
		rootSecond.setContent(listeChambres);
		rootSecond.setFitToHeight(true);
		rootSecond.setFitToWidth(true);
	}
	
	private ObservableList<Chambre> getChambres() {
		Chambre chambre1 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre2 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre3 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre4 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre5 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre6 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre7 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre8 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre9 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre10 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre11 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre12 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre13 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre14 = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		Chambre chambre = new Chambre("300 m2", "0755032386", "2", 2, 0, 0, 0, 250.0, 1.5);
		chambre.setIdChambre(1);	chambre.setEtat(EtatChambre.OCCUPEE);
		chambre1.setIdChambre(2);
		chambre2.setIdChambre(3);	chambre2.setEtat(EtatChambre.OCCUPEE);
		chambre3.setIdChambre(4);   chambre3.setEtat(EtatChambre.OCCUPEE);
		chambre4.setIdChambre(5);
		chambre5.setIdChambre(6);
		chambre6.setIdChambre(7);	chambre6.setEtat(EtatChambre.OCCUPEE);
		chambre7.setIdChambre(8);
		chambre8.setIdChambre(2);	chambre8.setEtat(EtatChambre.OCCUPEE);
		chambre9.setIdChambre(3);
		chambre10.setIdChambre(4);
		chambre11.setIdChambre(5);
		chambre12.setIdChambre(6);
		chambre13.setIdChambre(7);
		chambre14.setIdChambre(8);
		
		ObservableList<Chambre> chambres = FXCollections.observableArrayList();
		chambres.add(chambre);
		chambres.add(chambre1);
		chambres.add(chambre2);
		chambres.add(chambre3);
		chambres.add(chambre4);
		chambres.add(chambre5);
		chambres.add(chambre6);
		chambres.add(chambre8);
		chambres.add(chambre9);
		chambres.add(chambre10);
		chambres.add(chambre11);
		chambres.add(chambre12);
		chambres.add(chambre13);
		chambres.add(chambre14);
		chambres.add(chambre7);
		
		return chambres;
		
	}

}
