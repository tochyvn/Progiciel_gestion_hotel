/**
 * 
 */
package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author silnti
 *
 */
public class TypePoste {
	
	private IntegerProperty identifiant;
	private StringProperty libelle;

	/**
	 * 
	 */
	public TypePoste() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identifiant
	 * @param libelle
	 */
	public TypePoste(String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public final IntegerProperty identifiantProperty() {
		return this.identifiant;
	}
	

	public final int getIdentifiant() {
		return this.identifiantProperty().get();
	}
	

	public final void setIdentifiant(int identifiant) {
		this.identifiant = new SimpleIntegerProperty(identifiant);
	}
	

	public final StringProperty libelleProperty() {
		return this.libelle;
	}
	

	public final String getLibelle() {
		return this.libelleProperty().get();
	}
	

	public final void setLibelle(String libelle) {
		this.libelle = new SimpleStringProperty(libelle);
	}

}
