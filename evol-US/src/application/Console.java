package application;

import controller.ChambreManager;
import controller.UserPosteDirectionManager;
import controller.UtilisateurManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.Chambre;
import model.beans.Client;
import model.beans.UserPosteDirection;
import model.beans.Utilisateur;
import model.dao.ClientDAO;
import model.exception.CreateObjectException;

public class Console {

	public Console() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//Permet d'envoyer des requête à la bd
		//ClientDAO customerDAO = new ClientDAO(Connexion.getConnexion());
		
		
		
		/**
		 * Teste fonctionnel de d'insert des clients
		 */
		/*
		Customer customer = null;
		try {
			customer = new Customer("NIANG", "FALLOU", "65 Avenue du Merlan", 
					"13014", "Marseille", "France", 
					"f_NIANG", "ghjh131451hju8978iio89");
			customerDAO.create(customer);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Customer customer1 = null;
		try {
			customer1 = new Customer("TOCHAP NGASSAM", "Lionel", "25 Rue Honnorat", 
					"13003", "Marseille", "France", 
					"f_NIANG", "hsjkdhfjsd887gjjhghj78hjgh88");
			customerDAO.create(customer1);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		/**
		 * Teste fonctionnel de l'update des clients
		 */
		/*
		Customer customer3 = new Customer("NIANG AMY", "FALLOU", "65 Avenue du Merlan", 
				"13014", "Marseille", "France", 
				"f_niangamy", "ghjh131451hju8978iio89");
		//Pour savoir l'id à update
		customer3.setId(1);
		customerDAO.update(customer3);
		
	*/
		/**
		 * Teste fonctionnel de listing des clients
		 */
		//customerDAO.findAll(FXCollections.observableArrayList());
		
		//System.out.println(customerDAO.findById(1));
		/*
		ObservableList<UserPosteDirection> postes = FXCollections.observableArrayList();
		UserPosteDirectionManager.getInstance().findAll(postes);
		System.out.println(postes.get(1));
		*/
		
		/*
		ObservableList<Utilisateur> users = FXCollections.observableArrayList();
		UtilisateurManager.getInstance().findAll(users);
		*/
		//UtilisateurManager.getInstance().deconnected();
		
		ObservableList<Chambre> chambres = FXCollections.observableArrayList();
		ChambreManager.getInstance().findAll(chambres);
	}

}
