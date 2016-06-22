package model.beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class LigneFacture {

	private IntegerProperty idLigne;

	private IntegerProperty qte;

	private DoubleProperty tva;

	private Facture facture;

	private Produit produit;

	/**
	 * 
	 */
	public LigneFacture() {
		super();
	}

	/**
	 * @param idLigne
	 * @param qte
	 * @param tva
	 * @param facture
	 * @param produit
	 */
	public LigneFacture(Integer qte, Double tva, Facture facture, Produit produit) {
		super();
		this.qte = new SimpleIntegerProperty(qte);
		this.tva = new SimpleDoubleProperty(tva);
		this.facture = facture;
		this.produit = produit;
	}

	public IntegerProperty idLigneProperty() {
		return this.idLigne;
	}
	

	public Integer getIdLigne() {
		return this.idLigneProperty().get();
	}
	

	public void setIdLigne(Integer idLigne) {
		this.idLigne = new SimpleIntegerProperty(idLigne);
	}
	

	public IntegerProperty qteProperty() {
		return this.qte;
	}
	

	public Integer getQte() {
		return this.qteProperty().get();
	}
	

	public void setQte(Integer qte) {
		this.qte = new SimpleIntegerProperty(qte);
	}

	public DoubleProperty tvaProperty() {
		return this.tva;
	}
	

	public Double getTva() {
		return this.tvaProperty().get();
	}
	

	public void setTva(Double tva) {
		this.tva = new SimpleDoubleProperty(tva);
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
