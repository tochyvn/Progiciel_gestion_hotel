package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Produit {

	private IntegerProperty idProduit;
	
	
	public Produit() {
		super();
	}

	public IntegerProperty idProduitProperty() {
		return this.idProduit;
	}

	public int getIdProduit() {
		return this.idProduitProperty().get();
	}
	
	public void setIdProduit(int idProduit) {
		this.idProduit = new SimpleIntegerProperty(idProduit);
	}
	

	

}
