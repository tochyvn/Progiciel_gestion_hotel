package view.restaurant;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApplication;
import controller.UserPosteDirectionManager;
import controller.UtilisateurManager;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import library.LoaderOfScene;
import model.beans.UserPosteDirection;
import model.beans.Utilisateur;
import view.ViewInterfaceConstante;

public class StockController implements Initializable {

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

	public StockController() {

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
	
	@FXML
	private void loadViewStock() {
		Parent stockOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.STOCK_VIEW, 1);
		((BorderPane)(MainApplication.primaryStage.getScene().getRoot())).setCenter(stockOverview);;
		System.out.println(MainApplication.primaryStage.getScene().getRoot());
		DoubleProperty opacity = stockOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	@FXML
	private void loadViewReservation() {
		Parent reservationOverview = (AnchorPane) LoaderOfScene.loadParent(ViewInterfaceConstante.RESERVATION_VIEW, 1);
		((BorderPane)(MainApplication.primaryStage.getScene().getRoot())).setCenter(reservationOverview);;
		System.out.println(MainApplication.primaryStage.getScene().getRoot());
		DoubleProperty opacity = reservationOverview.opacityProperty();
		//Animation.doAnimationProperty(opacity, 0, 1);
	}
	
	
	@FXML
	public void create() {
		
	}

	@FXML
	public void update() {

	}

	@FXML
	public void delete() {

	}

	@FXML
	public void raz() {

	}

}
