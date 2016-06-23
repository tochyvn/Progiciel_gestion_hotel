package view.statistique;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class StatistiqueMaintenanceController implements Initializable {
	
	@FXML
	private AnchorPane anchorPane;

	public StatistiqueMaintenanceController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Chargement du graphique
		Parent maintenance = LoaderOfScene.loadParent(ViewInterfaceConstante.GRAPHE_MAINTENANCE, 0);
		anchorPane.getChildren().add(maintenance);
		AnchorPane.setBottomAnchor(maintenance, 0.0);
		AnchorPane.setLeftAnchor(maintenance, 0.0);
		AnchorPane.setRightAnchor(maintenance, 0.0);
		AnchorPane.setTopAnchor(maintenance, 0.0);
		//anchorPane.setPrefSize(900, 500);
	}

}
