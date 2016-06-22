package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.beans.LivreOr;

public class LivreOrDAO extends DAO<LivreOr> {

	public LivreOrDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(LivreOr objet) {
		String sql = "INSERT INTO LivreOr VALUES (NULL, ?, ?, ?)";
		int status = 0;
		
		try {
			if (connexion != null) {
				PreparedStatement requete = this.connexion.prepareStatement(sql);
				requete.setDate(1,  objet.getDateCommentaire());
				requete.setString(2,objet.getNomClient());
				requete.setString(3, objet.getCommentaire());
				
				System.out.println("Insertion réussie.");
			}else {
				status = 3;
			}
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête SQL : "+e.getMessage());
		}
		
		return status;
	}

	@Override
	public int update(LivreOr objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LivreOr findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ObservableList<LivreOr> findAll() {
		String sql = "SELECT * FROM LivreOr";
		ObservableList<LivreOr> arrayList1 = FXCollections.observableArrayList();
		
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				System.out.println(resultat.getString("nomClient"));
				System.out.println(resultat.getString("commentaire"));
				System.out.println(resultat.getString("dateCommentaire"));
				
				LivreOr livreOr;
				
			}
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete SELECT : "+ e.getMessage());
			e.printStackTrace();
			
		}
		
		return arrayList1;
	}

	@Override
	public void findAll(ObservableList<LivreOr> arrayList) {
		// TODO Auto-generated method stub
		
	}

}
