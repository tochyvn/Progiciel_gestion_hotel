package model.beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Boisson extends Produit {

	private StringProperty libelle;

	private DoubleProperty prix;
	
	
	public Boisson() {
		super();
	}
	
	
	/**
	 * @param libelle
	 * @param prix
	 */
	public Boisson(String libelle, double prix) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
		this.prix = new SimpleDoubleProperty(prix);
	}


	public void setLibelle(String libelle) {
		this.libelle = new SimpleStringProperty(libelle);
	}

	public String getLibelle() {
		return this.libelle.get();
	}
	
	public StringProperty libelleProperty() {
		return this.libelle;
	}


	public DoubleProperty prixProperty() {
		return this.prix;
	}
	
	public double getPrix() {
		return this.prixProperty().get();
	}
	
	public void setPrix(double prix) {
		this.prix = new SimpleDoubleProperty(prix);
	}
	
}
