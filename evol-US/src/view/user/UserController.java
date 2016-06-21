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
	private TableColumn<Utilisateur, Double> tblColumnSalaire;

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
		tblColumnSalaire.setCellValueFactory(new PropertyValueFactory<Utilisateur, Double>("salaire"));
		tblColumnAdresse.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adresse"));
		tblColumnCodeP.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("codePostal"));
		tblColumnPoste.setCellValueFactory(new PropertyValueFactory<Utilisateur, UserPosteDirection>("poste"));
	}

	@FXML
	public void create() {
		int status = 0;
		try {
			Double salaire = 0.0;
			if (!txtSalaire.getText().equals("") && !Double.valueOf(txtSalaire.getText()).isNaN()) {
				salaire = Double.valueOf(txtSalaire.getText());
			}
			Utilisateur user = new Utilisateur(
					txtNom.getText(), 
					txtPrenom.getText(), 
					txtAdresse.getText(), 
					txtCodePostal.getText(), 
					txtLogin.getText(), 
					txtPassword.getText(), 
					cmbPoste.getSelectionModel().getSelectedItem(),
					salaire
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

	}

	@FXML
	public void delete() {

	}

	@FXML
	public void raz() {
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
