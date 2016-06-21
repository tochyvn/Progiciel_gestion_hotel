package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import library.Cryptographie;
import model.beans.Client;
import model.exception.CreateObjectException;

public class ClientDAO extends DAO<Client> {

	public ClientDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Client objet) {
		String sql = "INSERT INTO client VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int status = 0;
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getAdresse());
			requete.setString(4, objet.getCodePostal());
			requete.setString(5, objet.getVille());
			requete.setString(6, objet.getPays());
			requete.setString(7, objet.getLogin());
			requete.setString(8, Cryptographie.encodePassword(objet.getPassword()));
			requete.setString(9, objet.getCbNum());
			requete.setDate(10, Date.valueOf(objet.getCbDateExp()));
			status = requete.executeUpdate();
			
			System.out.println("Insertion réussie waouhhh youpiiiii!!!!!!!!  "+status);
		} catch (SQLException e) {
			System.out.println("Erreur dans le DELETE SQL "+e.getMessage());
			//e.printStackTrace();
		}
		return status;
	}

	@Override
	public int update(Client objet) {
		int status = 0;
		String sql = "UPDATE client SET nom = ?, "
					+ "prenom = ?, "
					+ "adresse = ?, "
					+ "code_postal = ?, "
					+ "ville = ?, "
					+ "pays = ?, "
					+ "login = ?, "
					+ "password = ?, "
					+ "cb_num = ?, "
					+ "cb_date_exp = ?,"
					+ "cb_code = ?"
				+ "WHERE id_client = ?;";
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setString(1, objet.nomProperty().get());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getAdresse());
			requete.setString(4, objet.getCodePostal());
			requete.setString(5, objet.getVille());
			requete.setString(6, objet.getPays());
			requete.setString(7, objet.getLogin());
			requete.setString(8, Cryptographie.encodePassword(objet.getPassword()));
			requete.setString(9, Cryptographie.encodePassword(objet.getCbNum()));
			requete.setDate(10, Date.valueOf(objet.getCbDateExp()));
			requete.setString(11, Cryptographie.encodePassword(objet.getCbCode()));
			requete.setInt(12, objet.getId());
			status = requete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM client WHERE id_client = ?";
		int status = 0;
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setInt(1, id);
			status = requete.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête DELETE SQL "+e.getMessage());
		}
		
		return status;
	}

	
	@Override
	public Client findById(Integer id) {
		
		String sql = "SELECT * FROM client WHERE id_client = ?";
		Client customer = null;
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			//S'il y a un resultat
			if (resultat.next()) {
				try {
					customer = new Client(
							resultat.getString("nom"),
							resultat.getString("prenom"),
							resultat.getString("adresse"),
							resultat.getString("code_postal"),
							resultat.getString("ville"),
							resultat.getString("pays"),
							resultat.getString("login"),
							resultat.getString("password"),
							resultat.getString("cb_num"),
							resultat.getDate("cb_date_exp").toLocalDate(),
							resultat.getString("cb_code")
					);
					customer.setId(id);
				} catch (CreateObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR dans la requete SELECT : "+e.getMessage());
			//e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public void findAll(ObservableList<Client> arrayList) {
		
		String sql = "SELECT * FROM client";
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				Client customer;
				try {
					customer = new Client(
							resultat.getString("nom"),
							resultat.getString("prenom"),
							resultat.getString("adresse"),
							resultat.getString("code_postal"),
							resultat.getString("ville"),
							resultat.getString("pays"),
							resultat.getString("login"),
							resultat.getString("password"),
							resultat.getString("cb_num"),
							resultat.getDate("cb_date_exp").toLocalDate(),
							resultat.getString("cb_code")
					);
					customer.setId(resultat.getInt("id_client"));
					arrayList.add(customer);
				} catch (CreateObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR dans la requete SELECT : "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
