package model.beans;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.beans.old.Chambre;

public class Tarif {

	private DoubleProperty prix;
	private ObjectProperty<LocalDate> date;
	private Chambre chambre;

	/**
	 * 
	 */
	public Tarif() {
		super();
	}

	/**
	 * @param prix
	 * @param date
	 * @param chambre
	 */
	public Tarif(Integer prix, LocalDate date, Chambre chambre) {
		super();
		this.prix = new SimpleDoubleProperty(prix);
		this.date = new SimpleObjectProperty<LocalDate>(date);
		this.setChambre(chambre);
	}

	public DoubleProperty prixProperty() {
		return this.prix;
	}
	

	public Double getPrix() {
		return this.prixProperty().get();
	}
	

	public void setPrix(Double prix) {
		this.prix = new SimpleDoubleProperty(prix);
	}
	

	public ObjectProperty<LocalDate> dateProperty() {
		return this.date;
	}
	

	public LocalDate getDate() {
		return this.dateProperty().get();
	}
	

	public void setDate(LocalDate date) {
		this.date = new SimpleObjectProperty<LocalDate>(date);
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

}
