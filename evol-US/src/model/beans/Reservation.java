package model.beans;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.exception.CreateObjectException;

public class Reservation extends Produit {
	
	private ObjectProperty<LocalDate> dateDebut;
	private ObjectProperty<LocalDate> dateFin;
	private Date date;
	private Chambre chambre;
	private Client client;
	private EtatReservation statut;
	
	
	public Reservation() {
		super();
	}


	public Reservation(LocalDate dateDebut, LocalDate dateFin, Chambre chambre,
			Client client) throws CreateObjectException {
		super(Chambre.TVA);
		Double debut = (double) (Date.valueOf(dateDebut).getTime()/86400000);
		Double fin = (double) (Date.valueOf(dateFin).getTime()/86400000);
		Double now = (double) (Date.valueOf(LocalDate.now()).getTime()/86400000);
		this.date = Date.valueOf(LocalDate.now());
		
		if(fin>debut && debut>=now && fin>=debut)
		{
			this.dateDebut = new SimpleObjectProperty<>(dateDebut);
			this.dateFin = new SimpleObjectProperty<>(dateFin);
		}
		else
		{
			throw new CreateObjectException("Veuillez renseigner des dates valides", "Erreur dans les dates");
		}
		
		this.chambre = chambre;
		this.client = client;
		this.statut = EtatReservation.EN_COURS;
	}

	public final ObjectProperty<LocalDate> dateDebutProperty() {
		return this.dateDebut;
	}

	public final java.time.LocalDate getDateDebut() {
		return this.dateDebutProperty().get();
	}

	public final void setDateDebut(final LocalDate dateDebut) {
		this.dateDebut = new SimpleObjectProperty<>(dateDebut);
	}

	public final ObjectProperty<LocalDate> dateFinProperty() {
		return this.dateFin;
	}

	public final java.time.LocalDate getDateFin() {
		return this.dateFinProperty().get();
	}

	public final void setDateFin(final LocalDate dateFin) {
		this.dateFin = new SimpleObjectProperty<>(dateFin);
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EtatReservation getStatut() {
		return statut;
	}
	
	public String getStatutString() {
		String status = "EN_COURS";
		if (this.statut == EtatReservation.ANNULEE) {
			status = "ANNULEE";
		}else if (this.statut == EtatReservation.EXPIREE) {
			status = "EXPIREE";
		}else if (this.statut == EtatReservation.LIBEREE) {
			status = "LIBEREE";
		}
		
		return status;
	}
	
	public static EtatReservation getEtatReservationEnum(String etat) {
		EtatReservation etatEnum = null;
		if(etat.equals("EXPIREE")) {
			etatEnum = EtatReservation.EXPIREE;
		}else if (etat.equals("ANNULEE")) {
			etatEnum = EtatReservation.ANNULEE;
		}else if (etat.equals("LIBEREE")){
			etatEnum = EtatReservation.LIBEREE;
		}else if (etat.equals("ENCOURS")) {
			etatEnum = EtatReservation.EN_COURS;
		}
		
		return etatEnum;
	}

	public void setStatut(EtatReservation statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "NUM : "+getId()+" Client : "+getClient()+" Chambre : "+getChambre();
	}
	
	
}
