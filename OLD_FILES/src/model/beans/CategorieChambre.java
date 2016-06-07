package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategorieChambre {
	
	private IntegerProperty idCategorie;
	private StringProperty libelleCategorie;

	public CategorieChambre() {
		
	}

	/**
	 * @param libelleCategorie
	 */
	public CategorieChambre(String libelleCategorie) {
		super();
		this.libelleCategorie = new SimpleStringProperty(libelleCategorie);
	}

	/**
	 * 
	 * @return
	 */
	public final IntegerProperty idCategorieProperty() {
		return this.idCategorie;
	}
	
	/**
	 * 
	 * @return
	 */
	public final int getIdCategorie() {
		return this.idCategorieProperty().get();
	}
	
	/**
	 * 
	 * @param idCategorie
	 */
	public final void setIdCategorie(final int idCategorie) {
		this.idCategorie = new SimpleIntegerProperty(idCategorie);
	}
	
	/**
	 * 
	 * @return
	 */
	public final StringProperty libelleCategorieProperty() {
		return this.libelleCategorie;
	}
	
	/**
	 * 
	 * @return
	 */
	public final java.lang.String getLibelleCategorie() {
		return this.libelleCategorieProperty().get();
	}
	
	/**
	 * 
	 * @param libelleCategorie
	 */
	public final void setLibelleCategorie(final java.lang.String libelleCategorie) {
		this.libelleCategorieProperty().set(libelleCategorie);
	}

}
