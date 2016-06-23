package controller;

import java.sql.SQLException;

import application.MainApplication;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import library.LoaderOfScene;
import model.Connexion;
import model.beans.Utilisateur;
import model.dao.UtilisateurDAO;
import view.ViewInterfaceConstante;
import view.composants.alerte.AlertConfirmation;

public class UtilisateurManager {
	
	private static UtilisateurManager manager = null;
	private UtilisateurDAO utilisateurDAO;
	/**
	 * Permet de connaître l'état de la connexion à tout moment
	 * false s'il n'est pas connecté
	 * true s'il est connecté
	 */
	public static boolean isConnected = false;
	/**
	 * Permet de connaître le type d'utilisateur connecté
	 */
	public static String typeCompte = "AUCUN";

	private UtilisateurManager() {
		utilisateurDAO = new UtilisateurDAO(Connexion.getConnexion());
	}
	
	public static UtilisateurManager getInstance() {
		if (manager == null) {
			manager = new UtilisateurManager();
		}
		return manager;
	}
	
	public int create(Utilisateur objet) {
		int status = utilisateurDAO.create(objet);
		return status;
	}

	public int update(Utilisateur objet) {
		int status = utilisateurDAO.update(objet);
		return status;
	}

	public int delete(Integer id) {
		int status = utilisateurDAO.delete(id);
		return status;
	}
	
	public Utilisateur findById(Integer id) {
		return utilisateurDAO.findById(id);
	}

	public void findAll(ObservableList<Utilisateur> arrayList) {
		utilisateurDAO.findAll(arrayList);
	}
	
	public int getConnexion(Utilisateur user) {
		int connected = 0;
		connected = utilisateurDAO.getConnexion(user);
		//System.out.println("User.getPost()" + user+" === "+typeCompte);
		if (connected == 0) {
			//Boite de dialogue password ou identifiant incorrect
			System.out.println("Boite de dialogue : identifiant ou mot de passe incorrect.");
			AlertConfirmation alert = new AlertConfirmation("Mot de passe ou identifiant incorrecte", "Veuillez recommencez");
			alert.showAndWait();
		}else if (connected == 1) {
			//Sauvegarde de la connexion de l'utilisateur
			isConnected = true;
			//Rechargement de la scene principale apr�s connexion
			Scene scenePrincipale = LoaderOfScene.loadScene(ViewInterfaceConstante.ROOT_VIEW, 0);
			MainApplication.primaryStage.setScene(scenePrincipale);
			
			if(typeCompte.equals("DIRECTION")) {
				Parent center1 = LoaderOfScene.loadParent(ViewInterfaceConstante.HEBERGEMENT_STATISTIQUE, 1);
				
				((BorderPane) MainApplication.primaryStage.getScene().getRoot()).setCenter(center1);
				/*
				Parent chambre = LoaderOfScene.loadParent(ViewInterfaceConstante.GRAPHE_CHAMBRE, 0);
				((AnchorPane)center1).getChildren().add(chambre);
				AnchorPane.setBottomAnchor(chambre, 0.0);
				AnchorPane.setLeftAnchor(chambre, 0.0);
				AnchorPane.setRightAnchor(chambre, 0.0);
				AnchorPane.setTopAnchor(chambre, 0.0);
				*/
				System.out.println((MainApplication.primaryStage.getScene().getRoot()));
				DoubleProperty opacity = center1.opacityProperty();
				//Animation.doAnimationProperty(opacity, 0, 1);
			} else if(typeCompte.equals("MAINTENANCE")) {
				Parent center1 = LoaderOfScene.loadParent(ViewInterfaceConstante.REPARATION_HOTEL_VIEW, 1);
				((BorderPane) MainApplication.primaryStage.getScene().getRoot()).setCenter(center1);
				
				System.out.println((MainApplication.primaryStage.getScene().getRoot()));
				DoubleProperty opacity = center1.opacityProperty();
				//Animation.doAnimationProperty(opacity, 0, 1);
				
			} else if(typeCompte == "SPA") {
				Parent center1 = LoaderOfScene.loadParent(ViewInterfaceConstante.SPA_VIEW, 1);
				((BorderPane) MainApplication.primaryStage.getScene().getRoot()).setCenter(center1);
				System.out.println((MainApplication.primaryStage.getScene().getRoot()));
				DoubleProperty opacity = center1.opacityProperty();
				//Animation.doAnimationProperty(opacity, 0, 1);
				
			} else if(typeCompte == "GOUVERNANTE") {
				Parent center1 = LoaderOfScene.loadParent(ViewInterfaceConstante.NETTOYAGE_VIEW, 1);
				((BorderPane) MainApplication.primaryStage.getScene().getRoot()).setCenter(center1);
				System.out.println((MainApplication.primaryStage.getScene().getRoot()));
				DoubleProperty opacity = center1.opacityProperty();
				//Animation.doAnimationProperty(opacity, 0, 1);
				
			} else if(typeCompte == "RECEPTION") {
				Parent center1 = LoaderOfScene.loadParent(ViewInterfaceConstante.PLANNING_VIEW, 1);
				((BorderPane) MainApplication.primaryStage.getScene().getRoot()).setCenter(center1);
				System.out.println((MainApplication.primaryStage.getScene().getRoot()));
				DoubleProperty opacity = center1.opacityProperty();
				//Animation.doAnimationProperty(opacity, 0, 1);
				
			}
			//On recupere le root de la scene principale
			
		}else {
			//Boite de dialogue probl�me de connexion
			System.out.println("Boite de dialogue : probl�me de connexion");
		}
		
		return connected;
	}
	
	/**
	 * Deconnexion d'un utilisateur
	 */
	public void deconnected() {
		
		try {
			System.out.println(Connexion.getConnexion().isClosed());
			Connexion.getConnexion().close();
			System.out.println(Connexion.getConnexion());
			System.out.println(Connexion.getConnexion().isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilisateurManager.isConnected = false;
		UtilisateurManager.typeCompte = "AUCUN (PAR DEFAUT)";
	}

}
