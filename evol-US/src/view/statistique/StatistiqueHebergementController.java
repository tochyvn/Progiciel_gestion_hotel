package view.statistique;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class StatistiqueHebergementController implements Initializable {
	
	@FXML
	private AnchorPane anchorPane;

	public StatistiqueHebergementController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Chargement du graphique
		Parent chambre = LoaderOfScene.loadParent(ViewInterfaceConstante.GRAPHE_CHAMBRE, 0);
		anchorPane.getChildren().add(chambre);
		AnchorPane.setBottomAnchor(chambre, 0.0);
		AnchorPane.setLeftAnchor(chambre, 0.0);
		AnchorPane.setRightAnchor(chambre, 0.0);
		AnchorPane.setTopAnchor(chambre, 0.0);
		//anchorPane.setPrefSize(900, 500);
	}

}
