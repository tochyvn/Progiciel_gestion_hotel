package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//import java.util.Collection;

public class Etat {

	private IntegerProperty idEtat;

	private StringProperty libelle;

	//private Collection<Chambre> chambre;
	
	
	public Etat() {
		super();
	}
	
	
	/**
	 * @param libelle
	 * @param chambre
	 */
	public Etat(String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public final IntegerProperty idEtatProperty() {
		return this.idEtat;
	}

	public final int getIdEtat() {
		return this.idEtatProperty().get();
	}

	public final void setIdEtat(Integer idEtat) {
		this.idEtat = new SimpleIntegerProperty(idEtat);
	}

	public final StringProperty libelleProperty() {
		return this.libelle;
	}
	
	public String getLibelle() {
		return this.libelleProperty().get();
	}
	
	public void setLibelle(String libelle) {
		this.libelle = new SimpleStringProperty(libelle);
	}
	

	
}
