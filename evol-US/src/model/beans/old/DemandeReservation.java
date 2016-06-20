package model.beans.old;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.beans.Chambre;
import model.beans.Client;
import model.beans.Produit;

public class DemandeReservation extends Produit {

	private ObjectProperty<LocalDate> dateArrivee;

	private ObjectProperty<LocalDate> dateSortie;

	private Client client;

	private Chambre chambre;
	
	
	/**
	 * 
	 */
	public DemandeReservation() {
		super();
	}
	
	
	/**
	 * @param dateArrivee
	 * @param dateSortie
	 * @param client
	 * @param chambre
	 */
	public DemandeReservation(LocalDate dateArrivee, LocalDate dateSortie,
			Client client, Chambre chambre) {
		super();
		this.dateArrivee = new SimpleObjectProperty<LocalDate>(dateArrivee);
		this.dateSortie = new SimpleObjectProperty<LocalDate>(dateSortie);
		this.client = client;
		this.chambre = chambre;
	}


	public ObjectProperty<LocalDate> dateArriveeProperty() {
		return this.dateArrivee;
	}

	public LocalDate getDateArrivee() {
		return this.dateArriveeProperty().get();
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = new SimpleObjectProperty<LocalDate>(dateArrivee);
	}

	public ObjectProperty<LocalDate> dateSortieProperty() {
		return this.dateSortie;
	}

	public LocalDate getDateSortie() {
		return this.dateSortieProperty().get();
	}
	
	public final void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = new SimpleObjectProperty<LocalDate>(dateSortie);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	

}
