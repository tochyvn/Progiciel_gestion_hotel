package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//import java.util.Collection;

public class CategorieChambre1 {

	private IntegerProperty idCategorie;

	private StringProperty libelle;

	//private Collection<Chambre> chambre;

	/**
	 * 
	 */
	public CategorieChambre1() {
		super();
	}

	/**
	 * @param idCategorie
	 * @param libelle
	 */
	public CategorieChambre1(String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public IntegerProperty idCategorieProperty() {
		return this.idCategorie;
	}
	

	public int getIdCategorie() {
		return this.idCategorieProperty().get();
	}
	

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = new SimpleIntegerProperty(idCategorie);
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
	
	
	

}
