/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.beans.Chambre;

/**
 * @author silnti
 *
 */
public class ChambreDAO extends DAO<Chambre> {

	public ChambreDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Chambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Chambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chambre findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<Chambre> arrayList) {
		String sql = "SELECT * FROM chambre";
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				Chambre chambre;
				chambre = new Chambre(
						resultat.getString("surface"),
						resultat.getString("telephone"),
						resultat.getString("etage"),
						resultat.getInt("nb_place"),
						resultat.getInt("douche"),
						resultat.getInt("baignoire"),
						resultat.getInt("fumeur"),
						resultat.getDouble("tarif"),
						resultat.getString("categorie")
						);
				chambre.setEtat(Chambre.getEtatChambreEnum(resultat.getString("etat")));
				chambre.setIdChambre(resultat.getInt("id_chambre"));
				System.out.println(chambre);
				arrayList.add(chambre);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR dans la requete SELECT : "+e.getMessage());
			e.printStackTrace();
		}


	}
	
	public ObservableList<Chambre> findAll() {
		String sql = "SELECT * FROM chambre";
		ObservableList<Chambre> arrayList = FXCollections.observableArrayList();
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				Chambre chambre;
				chambre = new Chambre(
						resultat.getString("surface"),
						resultat.getString("telephone"),
						resultat.getString("etage"),
						resultat.getInt("nb_place"),
						resultat.getInt("douche"),
						resultat.getInt("baignoire"),
						resultat.getInt("fumeur"),
						resultat.getDouble("tarif"),
						resultat.getString("categorie")
						);
				chambre.setEtat(Chambre.getEtatChambreEnum(resultat.getString("etat")));
				chambre.setIdChambre(resultat.getInt("id_chambre"));
				System.out.println(chambre);
				arrayList.add(chambre);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR dans la requete SELECT : "+e.getMessage());
			e.printStackTrace();
		}

		return arrayList;
	}

}
