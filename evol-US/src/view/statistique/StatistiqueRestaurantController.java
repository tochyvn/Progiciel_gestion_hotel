package view.statistique;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class StatistiqueRestaurantController implements Initializable {
	
	@FXML
	private AnchorPane anchorPane;

	public StatistiqueRestaurantController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Chargement du graphique
		Parent restaurant = LoaderOfScene.loadParent(ViewInterfaceConstante.GRAPHE_RESTAURANT, 0);
		anchorPane.getChildren().add(restaurant);
		AnchorPane.setBottomAnchor(restaurant, 0.0);
		AnchorPane.setLeftAnchor(restaurant, 0.0);
		AnchorPane.setRightAnchor(restaurant, 0.0);
		AnchorPane.setTopAnchor(restaurant, 0.0);
		//anchorPane.setPrefSize(900, 500);
	}

}
