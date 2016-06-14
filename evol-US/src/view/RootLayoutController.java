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
		} catch (IOException e1) {
			e1.printStackTrace();
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
	 * Gestion de l'affichage du menu enfonction du niveau d'acc�s de l'utilisateur connect�
	 */
	private void chechAuthentificationType() {
		String droit = UtilisateurManager.typeCompte;
		if (droit != "DIRECTEUR") {
			hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTEUR" && droit != "MAINTENANCE") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTEUR" && droit != "SPA") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTEUR" && droit != "RECEPTION") {
			//hyperStatistique.setVisible(false);
		}
		if (droit != "DIRECTEUR" && droit != "HEBERGEMENT") {
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
		Parent reservatonOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.USER_VIEW, 1);
		root.setCenter(reservatonOverview);
		DoubleProperty opacity = reservatonOverview.opacityProperty();
		Animation.doAnimationProperty(opacity, 0, 1);
	}
	

}
