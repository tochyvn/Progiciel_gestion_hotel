package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.UserPosteDirection;

public class UserPosteDirectionDAO extends DAO<UserPosteDirection> {

	public UserPosteDirectionDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(UserPosteDirection objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserPosteDirection objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserPosteDirection findById(Integer id) {
		return null;
	}

	@Override
	public void findAll(ObservableList<UserPosteDirection> arrayList) {
		String sql = "SELECT * FROM user_poste_direction";
		try {
			if (Connexion.getConnexion() == null) {
				System.out.println("Echec d'établissement de la connexion");
			}else {
				PreparedStatement requete = this.connexion.prepareStatement(sql);
				ResultSet resultat = requete.executeQuery();
				while(resultat.next()) {
					UserPosteDirection poste;
					poste = new UserPosteDirection(
							resultat.getString("libelle")
							);
					poste.setIdPoste(resultat.getInt("id_poste"));
					arrayList.add(poste);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur d'execution de la requête");
			e.printStackTrace();
		}
		
	}
	
	

}
