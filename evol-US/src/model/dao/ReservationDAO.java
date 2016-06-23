package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		
		String sql = "INSERT INTO demande_reservation VALUES(NULL, ?, ?, ?, ?, ?, ?)";
		int status = 0;
		try {
			if (connexion != null) {
				PreparedStatement requete = this.connexion.prepareStatement(sql);
				requete.setDate(1, Date.valueOf(objet.getDateDebut()));
				requete.setDate(2, Date.valueOf(objet.getDateFin()));
				requete.setDate(3, Date.valueOf(LocalDate.now()));
				requete.setString(4, objet.getStatutString());
				requete.setInt(6, objet.getChambre().getIdChambre());
				requete.setInt(5, objet.getClient().getId());
				status = requete.executeUpdate();
				
				System.out.println("Insertion réussie!!!!!!!!  "+status);
			}else {
				status = 3;
			}
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête SQL : "+e.getMessage());
			//e.printStackTrace();
		}
		
		return status;
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
