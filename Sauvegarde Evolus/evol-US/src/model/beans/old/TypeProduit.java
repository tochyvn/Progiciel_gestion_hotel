package model.beans.old;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class TypeProduit {
	
	protected IntegerProperty id;
	protected StringProperty libelle;
	protected DoubleProperty prix;

	public TypeProduit() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param libelle
	 * @param prix
	 */
	public TypeProduit(String libelle, double prix) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
		this.prix = new SimpleDoubleProperty(prix);
	}
	

	public void setId(Integer idBoisson) {
		this.id = new SimpleIntegerProperty(idBoisson);
	}

	public Integer getId() {
		return this.id.get();
	}
	
	public IntegerProperty idProperty() {
		return this.id;
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
