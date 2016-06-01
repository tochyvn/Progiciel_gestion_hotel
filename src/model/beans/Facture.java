package model.beans;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

//import java.util.Collection;

public class Facture {

	private IntegerProperty idFacture;

	private ObjectProperty<LocalDate> date;

	private Client client;

	private ModePaiement modePaiement;

	//private Collection<LigneFacture> lignes;
	
	/**
	 * 
	 */
	public Facture() {
		super();
	}

	/**
	 * @param idFacture
	 * @param date
	 * @param client
	 * @param modePaiement
	 */
	public Facture(LocalDate date, Client client, ModePaiement modePaiement) {
		super();
		this.date = new SimpleObjectProperty<LocalDate>(date);
		this.client = client;
		this.modePaiement = modePaiement;
	}

	public final IntegerProperty idFactureProperty() {
		return this.idFacture;
	}
	

	public final int getIdFacture() {
		return this.idFactureProperty().get();
	}
	

	public void setIdFacture(Integer idFacture) {
		this.idFacture = new SimpleIntegerProperty(idFacture);
	}
	

	public final ObjectProperty<LocalDate> dateProperty() {
		return this.date;
	}
	

	public LocalDate getDate() {
		return this.dateProperty().get();
	}
	

	public void setDate(LocalDate date) {
		this.date = new SimpleObjectProperty<LocalDate>(date);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

}
