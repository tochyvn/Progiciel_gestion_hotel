package model.beans;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.beans.old.Chambre;

public class Reparation {

	private IntegerProperty idReparation;

	private ObjectProperty<LocalDate> dateDebut;

	private ObjectProperty<LocalDate> dateFin;

	private StringProperty libelle;

	private Chambre chambre;

	/**
	 * 
	 */
	public Reparation() {
		super();
	}

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param libelle
	 * @param chambre
	 */
	public Reparation(LocalDate dateDebut, LocalDate dateFin,
			String libelle, Chambre chambre) {
		super();
		this.dateDebut = new SimpleObjectProperty<LocalDate>(dateDebut);
		this.dateFin = new SimpleObjectProperty<LocalDate>(dateFin);
		this.libelle = new SimpleStringProperty(libelle);
		this.chambre = chambre;
	}

	public IntegerProperty idReparationProperty() {
		return this.idReparation;
	}
	

	public int getIdReparation() {
		return this.idReparationProperty().get();
	}
	

	public void setIdReparation(int idReparation) {
		this.idReparation = new SimpleIntegerProperty(idReparation);
	}
	

	public ObjectProperty<LocalDate> dateDebutProperty() {
		return this.dateDebut;
	}
	

	public LocalDate getDateDebut() {
		return this.dateDebutProperty().get();
	}
	

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = new SimpleObjectProperty<LocalDate>(dateDebut);
	}
	

	public ObjectProperty<LocalDate> dateFinProperty() {
		return this.dateFin;
	}
	

	public LocalDate getDateFin() {
		return this.dateFinProperty().get();
	}
	

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = new SimpleObjectProperty<LocalDate>(dateFin);
	}
	

	public StringProperty libelleProperty() {
		return this.libelle;
	}
	

	public String getLibelle() {
		return this.libelleProperty().get();
	}
	

	public void setLibelle(String libelle) {
		this.libelle = new SimpleStringProperty(libelle);
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	
}
