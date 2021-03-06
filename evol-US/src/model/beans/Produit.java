package model.beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Produit {

	private IntegerProperty id;
	private DoubleProperty tva;
	
	
	public Produit() {
		super();
	}
	
	public Produit(Double tva) {
		this.tva = new SimpleDoubleProperty(tva);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}

	public int getId() {
		return this.idProperty().get();
	}
	
	public void setId(int idProduit) {
		this.id = new SimpleIntegerProperty(idProduit);
	}

	public final DoubleProperty tvaProperty() {
		return this.tva;
	}
	

	public final double getTva() {
		return this.tvaProperty().get();
	}
	

	public final void setTva(final double tva) {
		this.tva = new SimpleDoubleProperty(tva);
	}

}
