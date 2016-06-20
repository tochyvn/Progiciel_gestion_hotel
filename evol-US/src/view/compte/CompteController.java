/**
 * 
 */
package view.compte;

import java.net.URL;
import java.util.ResourceBundle;

import controller.UtilisateurManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.beans.Utilisateur;

/**
 * @author Aurora
 *
 */
public class CompteController implements Initializable {
	
	@FXML
	private TextField identifiant;
	
	@FXML
	private PasswordField password;

	/**
	 * 
	 */
	public CompteController() {
		
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

	}
	
	public void changeCloseColorToActivate() {
		//connect.setStyle("-fx-background-color: #2196F3;");
	}
	
	@FXML
	private void getConnexion() {
		System.out.println("Cliquez.");
		
		Utilisateur user = new Utilisateur();
		user.setLogin(this.identifiant.getText());
		user.setPassword(this.password.getText());
		//System.out.println(user);
		//System.out.println(this.identifiant.getText()+"  --------  "+this.password.getText());
		
		int connected = UtilisateurManager.getInstance().getConnexion(user);
		if (connected == 1) {
			//Chargement de la vue d'accueil selon le type de user
			System.out.println("Vous êtes bien connecté.");
		}else {
			System.out.println("Erreur de connexion STATUT : "+connected);
		}
		
	}
	
	@FXML
	public void raz() {
		identifiant.setText("");
		password.setText("");
	}
}
