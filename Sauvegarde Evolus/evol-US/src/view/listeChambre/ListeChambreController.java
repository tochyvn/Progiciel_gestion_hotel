package view.listeChambre;

import java.net.URL;
import java.util.ResourceBundle;

import controller.ChambreManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import view.composants.chambre.ListRoom;

public class ListeChambreController implements Initializable {
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private ScrollPane rootSecond;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ListRoom listeChambres = new ListRoom(ChambreManager.getInstance().findAll());
		rootSecond.setContent(listeChambres);
		rootSecond.setFitToHeight(true);
		rootSecond.setFitToWidth(true);
	}

}
