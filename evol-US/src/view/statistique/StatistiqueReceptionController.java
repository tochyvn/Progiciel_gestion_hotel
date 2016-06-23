package view.statistique;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class StatistiqueReceptionController implements Initializable {
	
	@FXML
	private AnchorPane anchorPane;

	public StatistiqueReceptionController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Chargement du graphique
		Parent reception = LoaderOfScene.loadParent(ViewInterfaceConstante.GRAPHE_RECEPTION, 0);
		anchorPane.getChildren().add(reception);
		AnchorPane.setBottomAnchor(reception, 0.0);
		AnchorPane.setLeftAnchor(reception, 0.0);
		AnchorPane.setRightAnchor(reception, 0.0);
		AnchorPane.setTopAnchor(reception, 0.0);
		//anchorPane.setPrefSize(900, 500);
	}

}
