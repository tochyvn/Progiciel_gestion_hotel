package view.client;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Validator;
import model.Connexion;
import model.beans.Client;
import model.dao.ClientDAO;
import model.exception.CreateObjectException;
import view.composants.alerte.AlertConfirmation;
import view.composants.alerte.AlertError;
import view.composants.alerte.AlertInfo;

public class ClientController implements Initializable {
	
	//Observable permettant de remplir la table
	private ObservableList<Client> customers;
	
	//Permet l'accès au données DAO du client
	private ClientDAO customerDAO;
	
	
	@FXML
	private TableView<Client> tblCustomer;
	
	@FXML
	private TableColumn<Client, Integer> tblColumnId;
	
	@FXML
	private TableColumn<Client, String> tblColumnNom;
	
	@FXML
	private TableColumn<Client, String> tblColumnPrenom;
	
	@FXML
	private TableColumn<Client, String> tblColumnAdresse;
	
	@FXML
	private TableColumn<Client, String> tblColumnCodeP;
	
	@FXML
	private TableColumn<Client, String> tblColumnLogin;
	
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
	private TextField txtVille;
	
	@FXML
	private TextField txtPays;
	
	@FXML
	private TextField txtLogin;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField cbNum;
	
	@FXML
	private DatePicker cbExp;
	
	@FXML
	private TextField cbCode;
	
	public ClientController() {
		customerDAO = new ClientDAO(Connexion.getConnexion());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		customers = FXCollections.observableArrayList();
		customerDAO.findAll(customers);
		tblCustomer.setItems(customers);
		
		//Matcher la correspondance tablView <-->Custom
		tblColumnId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
		tblColumnNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
		tblColumnPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
		tblColumnAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresse"));
		tblColumnCodeP.setCellValueFactory(new PropertyValueFactory<Client, String>("codePostal"));
		tblColumnLogin.setCellValueFactory(new PropertyValueFactory<Client, String>("login"));
		
	}
	
	@FXML
	private void create() {
		Client customer = null;
		Alert dialog = null;
		int status = 0;
		try {
			customer = new Client(txtNom.getText(), 
					txtPrenom.getText(), 
					txtAdresse.getText(), 
					txtCodePostal.getText(), 
					txtVille.getText(), 
					txtPays.getText(), 
					txtLogin.getText(), 
					txtPassword.getText(),
					cbNum.getText(),
					cbExp.getValue(),
					cbCode.getText()
			);
			
			status = customerDAO.create(customer);
			System.out.println("status "+status);
			if (status == 1) {
				dialog = new AlertInfo("Statut de votre demande", "Insertion reussie");
				dialog.showAndWait();
				int idLastCustomer = customers.get(customers.size()-1).getId();
				customer.setId(idLastCustomer+1);
				customers.add(customer);
				this.raz();
				
			}else {
				dialog = new AlertError("Statut de votre demande", "Echec d'insertion, veuillez ressayer à nouveau");
				dialog.showAndWait();
			}
		} catch (CreateObjectException e) {
			System.out.println("Erreur d'insertion");
			//e.printStackTrace();
		}
		
		
	}
	
	@FXML
	private void update() {
		Client customer = null;
		int status = 0;
		
		//Si l'idenfiant saisi est n'est pas un nombre
		if (!Validator.validateNombre(txtId.getText())) {
			AlertError dialog = new AlertError("Statut de votre demande", "Veuillez selectionner une ligne dans la table,"
					+ " avant de cliquer à nouveau sur le bouton [ UPDATE ]");
			dialog.showAndWait();
		}else {
			try {
				customer = new Client(txtNom.getText(),
						txtPrenom.getText(),
						txtAdresse.getText(),
						txtCodePostal.getText(), 
						txtVille.getText(),
						txtPays.getText(), 
						txtLogin.getText(),
						txtPassword.getText(),
						cbNum.getText(),
						cbExp.getValue(),
						cbCode.getText()
						);
				customer.setId(Integer.valueOf(txtId.getText()));
				status = customerDAO.update(customer);
				System.out.println(status);
				if (status == 1) {
					Alert dialog = new AlertInfo("Statut de votre demande", "Modification reussie");
					dialog.showAndWait();
					this.raz();
					//Mise à jour du customer dans l'observableList
					Integer selectedIndex = tblCustomer.getSelectionModel().getSelectedIndex();
					customers.set(selectedIndex, customer);
				}else {
					Alert dialog = new AlertInfo("Statut de votre demande", "Echec de votre modification, veuillez ressayer à nouveau");
					dialog.showAndWait();
				}
			} catch (CreateObjectException e) {
				System.out.println("Erreur de modification Customer");
				//e.printStackTrace();
			}
		}
		
	}
	
	@FXML
	private void delete() {
		
		int status = 0;
		Alert dialog = null;
		//Si l'idenfiant saisi est n'est pas un nombre
		if (!Validator.validateNombre(txtId.getText())) {
			 dialog = new AlertError("Statut de votre demande", "Veuillez selectionner une ligne dans la table,"
					+ " avant de cliquer à nouveau sur le bouton [ DELETE ]");
			dialog.showAndWait();
		}else {
			dialog = new AlertConfirmation("Statut de votre demande", "Etes-vous vraiment sûr de"
					+ " vouloir supprimer le client numero [ "+txtId.getText()+" ] : ["+txtNom.getText()+" ]");
			Optional<ButtonType> answer = dialog.showAndWait();
			if (answer.get() == ButtonType.OK) {
				System.out.println("Button OK");
				status = customerDAO.delete(Integer.valueOf(txtId.getText()));
				System.out.println(status);
				if (status == 1) {
					dialog = new AlertInfo("Statut de votre demande", "Suppression réussie");
					dialog.showAndWait();
					Client customer = tblCustomer.getSelectionModel().getSelectedItem();
					customers.remove(customer);
					this.raz();
				}else {
					dialog = new AlertError("Statut de votre demande", "Echec de suppression veuillez ressayer plustard");
					dialog.showAndWait();
				}
			}else {
				System.out.println("Button CANCEL");
			}
		}
	}
	
	@FXML
	private void selectedTblViewRow() {
		Client selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
		Integer index = tblCustomer.getSelectionModel().getSelectedIndex();
		
		if (index != -1) {
			System.out.println(tblCustomer.getSelectionModel().getSelectedIndex());
			txtId.setText(String.valueOf(selectedCustomer.getId()));
			txtNom.setText(selectedCustomer.getNom());
			txtPrenom.setText(selectedCustomer.getPrenom());
			txtAdresse.setText(selectedCustomer.getAdresse());
			txtVille.setText(selectedCustomer.getVille());
			txtCodePostal.setText(selectedCustomer.getCodePostal());
			txtPays.setText(selectedCustomer.getPays());
			txtLogin.setText(selectedCustomer.getLogin());
		}
	}
	
	@FXML
	private void raz() {
		txtId.setText("");
		txtNom.setText("");
		txtPrenom.setText("");
		txtAdresse.setText("");
		txtVille.setText("");
		txtCodePostal.setText("");
		txtPays.setText("");
		txtLogin.setText("");
		txtPassword.setText("");
	}
	

}
