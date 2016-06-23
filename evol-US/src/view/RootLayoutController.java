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
	
	@FXML
	private Hyperlink hyperMaintenance;
	
	@FXML
	private Hyperlink hyperClient;
	
	@FXML
	private Hyperlink hyperSpa;
	
	@FXML
	private Hyperlink hyperReception;
	
	@FXML
	private Hyperlink hyperGouvernante;
	
	
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
	private void loadViewMentionsL() {
		Parent mentionsOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.MENTIONS_VIEW, 1);
		root.setCenter(mentionsOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_MENTIONS, 3);
		root.setTop(header);
		DoubleProperty opacity = mentionsOverview.opacityProperty();
		DoubleProperty opacityheader = mentionsOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
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
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(false);
			hyperReception.setVisible(false);
			hyperSpa.setVisible(false);
			hyperGouvernante.setVisible(false);
			hyperMaintenance.setVisible(false);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
		if (droit == "MAINTENANCE") {
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(false);
			hyperReception.setVisible(false);
			hyperSpa.setVisible(false);
			hyperGouvernante.setVisible(false);
			hyperMaintenance.setVisible(true);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
		if (droit == "SPA") {
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(false);
			hyperReception.setVisible(false);
			hyperSpa.setVisible(true);
			hyperGouvernante.setVisible(false);
			hyperMaintenance.setVisible(false);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
		if (droit == "RECEPTION") {
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(true);
			hyperReception.setVisible(true);
			hyperSpa.setVisible(false);
			hyperGouvernante.setVisible(false);
			hyperMaintenance.setVisible(false);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
		if (droit == "GOUVERNANTE") {
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(false);
			hyperReception.setVisible(false);
			hyperSpa.setVisible(false);
			hyperGouvernante.setVisible(true);
			hyperMaintenance.setVisible(true);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
		if (droit == "SPA") {
			hyperStatistique.setVisible(false);
			hyperReservation.setVisible(false);
			hyperEmployee.setVisible(false);
			hyperReception.setVisible(false);
			hyperSpa.setVisible(true);
			hyperGouvernante.setVisible(true);
			hyperMaintenance.setVisible(true);
			hyperClient.setVisible(false);
			hyperStatistique.setVisible(false);
		}
	}
	
	@FXML
	private void loadViewReservation() {
		Parent reservatonOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.RESERVATION_VIEW, 1);
		root.setCenter(reservatonOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_RESTAURANT, 3);
		root.setTop(header);
		DoubleProperty opacity = reservatonOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
		DoubleProperty opacityheader = reservatonOverview.opacityProperty();
		//Animation.doAnimationProperty(opacityheader, 0, 1);
	}
	
	@FXML
	private void loadViewEmployee() {
		Parent userOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.USER_VIEW, 1);
		root.setCenter(userOverview);
		DoubleProperty opacity = userOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	private void loadViewChambre() {
		Parent chambreOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.CHAMBRE_VIEW, 1);
		root.setCenter(chambreOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_HOTEL, 3);
		root.setTop(header);
		DoubleProperty opacity = chambreOverview.opacityProperty();
		DoubleProperty opacityheader = chambreOverview.opacityProperty();
	}

	@FXML
	private void loadViewStatistiques() {
		Parent statistiquesOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.HEBERGEMENT_STATISTIQUE, 1);
		root.setCenter(statistiquesOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_STATISTIQUE, 3);
		root.setTop(header);
		DoubleProperty opacityheader = statistiquesOverview.opacityProperty();
		DoubleProperty opacity = statistiquesOverview.opacityProperty();
	}

	@FXML
	private void loadViewStock() {
		Parent stockOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.STOCK_VIEW, 1);
		root.setCenter(stockOverview);
		DoubleProperty opacity = stockOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewAgence() {
		Parent agenceOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.AGENCE_VIEW, 1);
		root.setCenter(agenceOverview);
		DoubleProperty opacity = agenceOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewLivreOr() {
		Parent livreOrOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.LIVRE_OR_VIEW, 1);
		root.setCenter(livreOrOverview);
		DoubleProperty opacity = livreOrOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewEncaissement() {
		Parent encaissementOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.ENCAISSEMENT_VIEW, 1);
		root.setCenter(encaissementOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_RECEPTION, 3);
		root.setTop(header);
		DoubleProperty opacity = encaissementOverview.opacityProperty();
		DoubleProperty opacityheader = encaissementOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewFactures() {
		Parent facturesOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.FACTURES_VIEW, 1);
		root.setCenter(facturesOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_RECEPTION, 3);
		root.setTop(header);
		DoubleProperty opacity = facturesOverview.opacityProperty();
		DoubleProperty opacityheader = facturesOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}


	@FXML
	private void loadViewPlanning() {
		Parent planningOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.PLANNING_VIEW, 1);
		root.setCenter(planningOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_RECEPTION, 3);
		root.setTop(header);
		DoubleProperty opacity = planningOverview.opacityProperty();
		DoubleProperty opacityheader = planningOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewSurMesure() {
		Parent surmesureOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.SURMESURE_VIEW, 1);
		root.setCenter(surmesureOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_RECEPTION, 3);
		root.setTop(header);
		DoubleProperty opacity = surmesureOverview.opacityProperty();
		DoubleProperty opacityheader = surmesureOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewSpa() {
		Parent spaOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.SPA_VIEW, 1);
		root.setCenter(spaOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_SPA, 3);
		root.setTop(header);
		DoubleProperty opacity = spaOverview.opacityProperty();
		DoubleProperty opacityheader = spaOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewNettoyage() {
		Parent nettoyageOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.NETTOYAGE_VIEW, 1);
		root.setCenter(nettoyageOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_GOUVERNANTE, 3);
		root.setTop(header);
		DoubleProperty opacity = nettoyageOverview.opacityProperty();
		DoubleProperty opacityheader = nettoyageOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}

	@FXML
	private void loadViewReparationHotel() {
		Parent reparationOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.REPARATION_HOTEL_VIEW, 1);
		root.setCenter(reparationOverview);
		Parent header = LoaderOfScene.loadParent(ViewInterfaceConstante.HEADER_MAINTENANCE, 3);
		root.setTop(header);
		DoubleProperty opacity = reparationOverview.opacityProperty();
		DoubleProperty opacityheader = reparationOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}	

	@FXML
	private void loadViewReparationResto() {
		Parent reparationOverview = LoaderOfScene.loadParent(ViewInterfaceConstante.REPARATION_RESTO_VIEW, 1);
		root.setCenter(reparationOverview);
		DoubleProperty opacity = reparationOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}	
	
}
