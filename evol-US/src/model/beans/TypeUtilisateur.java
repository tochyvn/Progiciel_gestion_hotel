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
public class TypeUtilisateur {
	
	private IntegerProperty id;
	private StringProperty libelle;

	/**
	 * 
	 */
	public TypeUtilisateur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param libelle
	 */
	public TypeUtilisateur(Integer id, String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public final IntegerProperty idProperty() {
		return this.id;
	}
	

	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
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
