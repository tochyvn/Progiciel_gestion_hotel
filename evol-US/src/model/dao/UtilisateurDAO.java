/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import library.Cryptographie;
import model.Connexion;
import model.beans.UserPosteDirection;
import model.beans.Utilisateur;
import model.exception.CreateObjectException;

/**
 * @author silnti
 *
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
	
	/**
	 * @param conn
	 */
	public UtilisateurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Utilisateur objet) {
		
		String sql = "INSERT INTO user VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
		int status = 0;
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getAdresse());
			requete.setString(4, objet.getCodePostal());
			requete.setString(5, objet.getLogin());
			requete.setString(6, Cryptographie.encodePassword(objet.getPassword()));
			requete.setInt(7, objet.getPoste().getIdPoste());
			status = requete.executeUpdate();
			
			System.out.println("Insertion réussie waouhhh youpiiiii!!!!!!!!  "+status);
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête SQL : "+e.getMessage());
			//e.printStackTrace();
		}
		return status;
	}

	@Override
	public int update(Utilisateur objet) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public Utilisateur findById(Integer id) {
		return null;
	}

	@Override
	public void findAll(ObservableList<Utilisateur> arrayList) {
		String sql = "SELECT * FROM user INNER JOIN user_poste_direction "
				+ "ON user_poste_direction.id_poste = user.id_poste";
		try {
			
			if (Connexion.getConnexion() == null) {
				System.out.println("Erreur lors de l'établissement de la connexion");
			}else {
				PreparedStatement requete = this.connexion.prepareStatement(sql);
				ResultSet resultat = requete.executeQuery();
				while(resultat.next()) {
					Utilisateur user;
					UserPosteDirection userPoste = new UserPosteDirection(resultat.getString("user_poste_direction.libelle"));
					userPoste.setIdPoste(resultat.getInt("user.id_poste"));
					user = new Utilisateur(
							resultat.getString("nom"),
							resultat.getString("prenom"),
							resultat.getString("adresse"),
							resultat.getString("code_postal"),
							resultat.getString("login"),
							resultat.getString("password"),
							userPoste
						);
					user.setId(resultat.getInt("user.id_user"));
					arrayList.add(user);
					System.out.println("ID : "+user.getId()+" NOM : "+user.getNom()+" POSTE : "+user.getPoste());
					
				}
				//Fermeture des curseurs ouverts
				resultat.close();
				requete.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur SQL dans findAllUtilisateur "+e.getMessage());
		} catch (CreateObjectException e) {
			//Cette exception ne sera jamais provoquée sachant que nous effectuons une opération de lecture des utilisateurs
			//Et qu'il y a contrôle avant insertion des utilisateurs
			System.out.println(e.getMessage());
			e.showError();
		} 
	}
	
	/**
	 * Permettant à un utilisateur de se connecter
	 * @param user représente un utilisateur demandant une connexion
	 * @return 1 s'il existe bien sinon 0
	 */
	public int getConnexion(Utilisateur user) {
		int status = 0;
		String sql = "SELECT * FROM user "
				+ "WHERE login = ? AND password = ?";
		try {
			if (this.connexion != null) {
				PreparedStatement requete = this.connexion.prepareStatement(sql);
				requete.setString(1, user.getLogin());
				requete.setString(2, Cryptographie.encodePassword(user.getPassword()));
				ResultSet resultat = requete.executeQuery();
				if (resultat.next()) {
					status = 1;
				}
				requete.close();
			}
		} catch (SQLException e) {
			System.out.println("Problème de connexion ou requête mal formée");
		}
		
		return status;
	}
	
}
