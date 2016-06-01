package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
	
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	private void loadViewClient(ActionEvent event) {
		System.out.println("Vous avez cliquez sur le menuItemCustomer");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(ViewInterface.CLIENT_VIEW));
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
		loader.setLocation(getClass().getResource(ViewInterface.CONNEXION_VIEW));
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
		loader.setLocation(getClass().getResource(ViewInterface.USER_VIEW));
		AnchorPane userOverview = null;
		try {
			userOverview = (AnchorPane)loader.load();
			System.out.println(root.getScene());
			root.setCenter(userOverview);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
/*
	@FXML
	private void handleMenuItemAction(ActionEvent e) {
		System.out.println(getClass().getName());
		if (e.getSource() == menuItemUser) {
			System.out.println("Vous avez cliquez sur le menuItemUser");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(ViewInterface.USER_VIEW));
			AnchorPane userOverview = null;
			try {
				userOverview = (AnchorPane)loader.load();
				System.out.println(root.getScene());
				root.setCenter(userOverview);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == menuItemCustomer) {
			System.out.println("Vous avez cliquez sur le menuItemCustomer");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(ViewInterface.CLIENT_VIEW));
			AnchorPane customerOverview = null;
			try {
				customerOverview = (AnchorPane)loader.load();
				root.setCenter(customerOverview);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == menuItemConnexion) {
			System.out.println("Vous avez cliquez sur le menuItemConnexion");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(ViewInterface.CONNEXION_VIEW));
			AnchorPane compteOverview = null;
			try {
				compteOverview = (AnchorPane)loader.load();
				root.setCenter(compteOverview);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}
*/

}
