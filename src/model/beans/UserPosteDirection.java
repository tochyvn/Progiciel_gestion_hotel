package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//import java.util.Collection;

public class UserPosteDirection {

	private IntegerProperty idPoste;

	private StringProperty libelle;
	
	//private Collection<Utilisateur> utilisateur;

	/**
	 * 
	 */
	public UserPosteDirection() {
		super();
	}

	/**
	 * @param idPoste
	 * @param libelle
	 */
	public UserPosteDirection(String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public IntegerProperty idPosteProperty() {
		return this.idPoste;
	}
	

	public int getIdPoste() {
		return this.idPosteProperty().get();
	}
	

	public void setIdPoste(Integer idPoste) {
		this.idPoste = new SimpleIntegerProperty(idPoste);
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
	
	@Override
	public String toString() {
		//return this.getIdPoste()+"- "+this.libelle.get();
		return this.libelle.get();
	}

}
