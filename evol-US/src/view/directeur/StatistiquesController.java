package view.directeur;

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

public class StatistiquesController implements Initializable {

	//Observable permettant de remplir la table
	private ObservableList<Utilisateur> utilisateurs;

	//Observable permettant de remplir le combobox
	private ObservableList<UserPosteDirection> postes;

	@FXML
	private TableView<Utilisateur> tblUser;

	@FXML
	private TableColumn<Utilisateur, Integer> tblColumnId;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnNom;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnPrenom;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnAdresse;

	@FXML
	private TableColumn<Utilisateur, String> tblColumnCodeP;

	@FXML
	private TableColumn<Utilisateur, UserPosteDirection> tblColumnPoste;

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

	public StatistiquesController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//REMPLISSAGE DU COMBOBOX
		postes = FXCollections.observableArrayList();
		UserPosteDirectionManager.getInstance().findAll(postes);
		cmbPoste.setItems(postes);
		//Pour selectionner AUCUN(PAR DEFAUT)
		cmbPoste.getSelectionModel().selectNext();

		//REMPLISSAGE DU TABLEAU D'UTILISATEUR
		utilisateurs = FXCollections.observableArrayList();
		UtilisateurManager.getInstance().findAll(utilisateurs);
		tblUser.setItems(utilisateurs);
		tblColumnId.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id"));
		tblColumnNom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
		tblColumnPrenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
		tblColumnAdresse.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adresse"));
		tblColumnCodeP.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("codePostal"));
		tblColumnPoste.setCellValueFactory(new PropertyValueFactory<Utilisateur, UserPosteDirection>("poste"));
	}



	

}