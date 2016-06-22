package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.UtilisateurManager;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import library.Animation;
import library.LoaderOfScene;

/**
 * @author silnti
 *
 */
public class RootLayoutController implements Initializable {

	//MenuItem permettant d'afficher la vue User(type AnchorPane)
	@FXML
	private MenuItem menuItemUser;
	
	//MenuItem permettant d'afficher la vue Customer(type AnchorPane)
	@FXML
	private MenuItem menuItemCustomer;
	
	@FXML
	private MenuItem menuItemConnexion;
	
	//Le parent de type BorderPane afin de changer son contenu
	@FXML
	private BorderPane root;
	
	@FXML
	private AnchorPane borderPaneLeft;
	
	@FXML
	private Hyperlink hyperStatistique;
	
	@FXML
	private FlowPane topLayout;
	
	@FXML
	private AnchorPane bottomLayout;
	
	@FXML 
	private AnchorPane rightLayout;
	
	@FXML
	private Hyperlink hyperReservation;
	
	@FXML
	private Hyperlink hyperEmployee;
	
	@FXML
	private Hyperlink hyperChambre;
	
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (UtilisateurManager.isConnected) {
			borderPaneLeft.setVisible(true);
			topLayout.setVisible(true);
			rightLayout.setVisible(true);
			bottomLayout.setVisible(true);
			Animation.doAnimationProperty(topLayout.opacityProperty(), 0, 2000);
		}
		if (!UtilisateurManager.isConnected) {
			borderPaneLeft.setVisible(false);
		}
		this.chechAuthentificationType();
	}
	
	@FXML
	private void loadViewClient(ActionEvent event) {
		System.out.println("Vous avez cliquez sur le menuItemCustomer");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(ViewInterfaceConstante.CLIENT_VIEW));
		AnchorPane customerOverview = null;
		try {
			customerOverview = (AnchorPane)loader.load();
			root.setCenter(customerOverview);
			DoubleProperty opacity = customerOverview.opacityProperty();
			Animation.doAnimationProperty(opacity, 0, 1);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	@FXML
	private void loadViewConnexion(ActionEvent event) {
		System.out.println("Vous avez cliquez sur le menuItemConnexion");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(ViewInterfaceConstante.CONNEXION_VIEW));
		AnchorPane compteOverview = null;
		try {
			compteOverview = (AnchorPane)loader.load();
			root.setCenter(compteOverview);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	private void loadViewUser(ActionEvent event) {
		System.out.println(getClass().getName());
		System.out.println("Vous avez cliquez sur le menuItemUser");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(ViewInterfaceConstante.USER_VIEW));
		AnchorPane userOverview = null;
		try {
			userOverview = (AnchorPane)loader.load();
			System.out.println(root.getScene());
			root.setCenter(userOverview);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Gestion de l'affichage du menu en fonction du niveau d'acc�s de l'utilisateur connexion
	 */
	private void chechAuthentificationType() {
		String droit = UtilisateurManager.typeCompte;
		if (droit != "DIRECTION") {
			hyperStatistique.setVisible(true);
		}
		if (droit != "DIRECTION" && droit != "MAINTENANCE") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTION" && droit != "SPA") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTION" && droit != "RECEPTION") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTION" && droit != "HEBERGEMENT") {
			//hyperStatistique.setVisible(false);
		}
	}
	
	@FXML
	private void loadViewReservation() {
		Parent reservatonOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.RESERVATION_VIEW, 1);
		root.setCenter(reservatonOverview);
		DoubleProperty opacity = reservatonOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void loadViewEmployee() {
		Parent userOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.USER_VIEW, 1);
		root.setCenter(userOverview);
		DoubleProperty opacity = userOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	private void loadViewChambre() {
		Parent chambreOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.CHAMBRE_VIEW, 1);
		root.setCenter(chambreOverview);
		DoubleProperty opacity = chambreOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewStatistiques() {
		Parent statistiquesOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.STATISTIQUES_VIEW, 1);
		root.setCenter(statistiquesOverview);
		DoubleProperty opacity = statistiquesOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewStock() {
		Parent stockOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.STOCK_VIEW, 1);
		root.setCenter(stockOverview);
		DoubleProperty opacity = stockOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewAgence() {
		Parent agenceOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.AGENCE_VIEW, 1);
		root.setCenter(agenceOverview);
		DoubleProperty opacity = agenceOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewLivreOr() {
		Parent livreOrOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.LIVRE_OR_VIEW, 1);
		root.setCenter(livreOrOverview);
		DoubleProperty opacity = livreOrOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewEncaissement() {
		Parent encaissementOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.ENCAISSEMENT_VIEW, 1);
		root.setCenter(encaissementOverview);
		DoubleProperty opacity = encaissementOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewFactures() {
		Parent facturesOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.FACTURES_VIEW, 1);
		root.setCenter(facturesOverview);
		DoubleProperty opacity = facturesOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}


	@FXML
	private void loadViewPlanning() {
		Parent planningOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.PLANNING_VIEW, 1);
		root.setCenter(planningOverview);
		DoubleProperty opacity = planningOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewSurMesure() {
		Parent surmesureOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.SURMESURE_VIEW, 1);
		root.setCenter(surmesureOverview);
		DoubleProperty opacity = surmesureOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewSpa() {
		Parent spaOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.SPA_VIEW, 1);
		root.setCenter(spaOverview);
		DoubleProperty opacity = spaOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewNettoyage() {
		Parent nettoyageOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.NETTOYAGE_VIEW, 1);
		root.setCenter(nettoyageOverview);
		DoubleProperty opacity = nettoyageOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewReparationHotel() {
		Parent reparationOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.REPARATION_HOTEL_VIEW, 1);
		root.setCenter(reparationOverview);
		DoubleProperty opacity = reparationOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}	

	@FXML
	private void loadViewReparationResto() {
		Parent reparationOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.REPARATION_RESTO_VIEW, 1);
		root.setCenter(reparationOverview);
		DoubleProperty opacity = reparationOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}	
	
}
