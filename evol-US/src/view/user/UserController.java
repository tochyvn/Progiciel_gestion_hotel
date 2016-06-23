package view.user;

import java.net.URL;
import java.util.ResourceBundle;

import controller.UserPosteDirectionManager;
import controller.UtilisateurManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.beans.UserPosteDirection;
import model.beans.Utilisateur;
import model.exception.CreateObjectException;
import view.composants.alerte.AlertConfirmation;
import view.composants.alerte.AlertError;

public class UserController implements Initializable {

	//Observable permettant de remplir la table
	private ObservableList<Utilisateur> utilisateurs;

	//Observable permettant de remplir le combobox
	private ObservableList<UserPosteDirection> postes;

	@FXML
	private TableView<Utilisateur> tblUser;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnNom;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnAdresse;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnCodeP;

	@FXML
	private TableColumn<Utilisateur, UserPosteDirection> tblColumnPoste;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnSalaire;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNom;

	@FXML
	private TextField txtPrenom;

	@FXML
	private TextField txtAdresse;

	@FXML
	private TextField txtCodePostal;

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtPassword;	

	@FXML
	private ComboBox<UserPosteDirection> cmbPoste;

	@FXML
	private TextField txtSalaire;

	public UserController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//REMPLISSAGE DU COMBOBOX
		postes = FXCollections.observableArrayList();
		UserPosteDirectionManager.getInstance().findAll(postes);
		cmbPoste.setItems(postes);
		//Pour selectionner AUCUN(PAR DEFAUT)
		//cmbPoste.getSelectionModel().selectNext();

		//REMPLISSAGE DU TABLEAU D'UTILISATEUR
		utilisateurs = FXCollections.observableArrayList();
		UtilisateurManager.getInstance().findAll(utilisateurs);
		tblUser.setItems(utilisateurs);
		tblColumnNom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
		tblColumnSalaire.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("salaire"));
		tblColumnAdresse.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adresse"));
		tblColumnCodeP.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("codePostal"));
		tblColumnPoste.setCellValueFactory(new PropertyValueFactory<Utilisateur, UserPosteDirection>("poste"));
	}

	@FXML
	public void create() {
		int status = 0;
		try {

			Utilisateur user = new Utilisateur(
					txtNom.getText(), 
					txtPrenom.getText(), 
					txtAdresse.getText(), 
					txtCodePostal.getText(), 
					txtLogin.getText(), 
					txtPassword.getText(), 
					cmbPoste.getSelectionModel().getSelectedItem(),
					txtSalaire.getText()
					);
			status = UtilisateurManager.getInstance().create(user);
			utilisateurs.add(user);
			if (status == 1) {
				AlertConfirmation  alert = new AlertConfirmation("Confirmation d'inscription", "inscription réussie");
				alert.showAndWait();
				this.raz();
			}
		} catch (CreateObjectException e) {
			System.out.println("Echec d'insertion : "+e.getMessage());
			e.showError();
		}
		System.out.println("fin de l'execution de la methode");
	}

	@FXML
	public void update() {
		int status = 0;
		try {

			Utilisateur user = new Utilisateur(
					txtNom.getText(), 
					txtPrenom.getText(), 
					txtAdresse.getText(), 
					txtCodePostal.getText(), 
					txtLogin.getText(), 
					txtPassword.getText(), 
					cmbPoste.getSelectionModel().getSelectedItem(),
					txtSalaire.getText()
					);
			user.setId(Integer.valueOf(txtId.getText()));
			status = UtilisateurManager.getInstance().create(user);
			if (status == 1) {
				AlertConfirmation  alert = new AlertConfirmation("Confirmation d'inscription", "Modification réussie");
				alert.showAndWait();
				this.raz();
				//Mise à jour du customer dans l'observableList
				Integer selectedIndex = tblUser.getSelectionModel().getSelectedIndex();
				utilisateurs.set(selectedIndex, user);
			}else {
				AlertError alert = new AlertError("Erreur", "Echec de la modification veuillez reesayer plus tard.");
				alert.showAndWait();
			}
		} catch (CreateObjectException e) {
			System.out.println("Echec d'insertion : "+e.getMessage());
			e.showError();
		}
	}

	@FXML
	public void delete() {
		int status = UtilisateurManager.getInstance().delete(Integer.valueOf(txtId.getText()));
		if (status == 1) {
			AlertConfirmation alert = new AlertConfirmation("Confirmation de suppression", "L'utilisateur [ "+txtNom.getText()+" ] à été supprimé avec succès");
			alert.showAndWait();
			this.raz();
			//Mise à jour du customer dans l'observableList
			Utilisateur user = tblUser.getSelectionModel().getSelectedItem();
			utilisateurs.remove(user);
			System.out.println("Le supprimé est : "+user);
		}else if (status == 3) {
			AlertError alert = new AlertError("Erreur de connexion", "Veuillez réessayer plustard.");
			alert.showAndWait();
		}
	}

	@FXML
	public void raz() {
		txtId.setText("");
		txtNom.setText("");
		txtPrenom.setText("");
		txtAdresse.setText("");
		txtCodePostal.setText("");
		txtLogin.setText("");
		txtPassword.setText("");
		txtSalaire.setText("");
	}

	@FXML
	private void selectedTblViewRow() {
		Utilisateur selectedCustomer = tblUser.getSelectionModel().getSelectedItem();
		Integer index = tblUser.getSelectionModel().getSelectedIndex();

		if (index != -1) {
			System.out.println(tblUser.getSelectionModel().getSelectedIndex());
			txtId.setText(String.valueOf(selectedCustomer.getId()));
			txtNom.setText(selectedCustomer.getNom());
			txtPrenom.setText(selectedCustomer.getPrenom());
			txtAdresse.setText(selectedCustomer.getAdresse());
			txtSalaire.setText(String.valueOf(selectedCustomer.getSalaire()));
			txtCodePostal.setText(selectedCustomer.getCodePostal());
			txtLogin.setText(selectedCustomer.getLogin());
			cmbPoste.getSelectionModel().select(selectedCustomer.getPoste());
		}
	}

}
