package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.Cryptographie;
import model.beans.Chambre;
import model.beans.Client;
import model.beans.Reservation;
import model.exception.CreateObjectException;

public class ReservationDAO extends DAO<Reservation> {

	public ReservationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Reservation objet) {
		/*
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
		*/
		return 0;
	}

	@Override
	public int update(Reservation objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reservation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<Reservation> arrayList) {
		
	}
	
	public ObservableList<Reservation> findAll() {
		String sql = "SELECT * FROM demande_reservation, chambre, client "
				+ "WHERE demande_reservation.id_chambre = chambre.id_chambre AND "
				+ "demande_reservation.id_client = client.id_client";
		ObservableList<Reservation> arrayList = FXCollections.observableArrayList();
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				System.out.println(resultat.getInt("nb_place"));
				System.out.println(resultat.getString("login"));
				System.out.println(resultat.getString("cb_date_exp"));
				Reservation reservation;
				Chambre chambre = new Chambre(
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
				
				Client client = new Client(
						resultat.getString("nom"),
						resultat.getString("prenom"),
						resultat.getString("adresse"),
						resultat.getString("code_postal"),
						resultat.getString("ville"),
						resultat.getString("pays"),
						resultat.getString("login"),
						resultat.getString("password"),
						resultat.getString("cb_num"),
						resultat.getString("cb_date_exp"),
						resultat.getString("cb_chiffres_derriere")
				);
				client.setId(resultat.getInt("id_client"));
				
				reservation = new Reservation(resultat.getDate("date_arrive").toLocalDate(),
						resultat.getDate("date_sortie").toLocalDate(),
						chambre,
						client
						);
				reservation.setId(resultat.getInt("id_demande_reservation"));
				reservation.setStatut(Reservation.getEtatReservationEnum(resultat.getString("etat_reservation")));
				
				System.out.println(reservation);
				arrayList.add(reservation);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR dans la requete SELECT : "+e.getMessage());
			e.printStackTrace();
		} catch (CreateObjectException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de creation du client");
			e.printStackTrace();
		}

		return arrayList;
	}

	

}
