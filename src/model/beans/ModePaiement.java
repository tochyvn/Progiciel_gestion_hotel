package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//import java.util.Collection;

public class ModePaiement {

	private IntegerProperty idMode;

	private StringProperty libelle;

	//private Collection<Facture> facture;
	
	
	public ModePaiement() {
		super();
	}

	/**
	 * @param idMode
	 * @param libelle
	 */
	public ModePaiement(String libelle) {
		super();
		this.libelle = new SimpleStringProperty(libelle);
	}

	public IntegerProperty idModeProperty() {
		return this.idMode;
	}
	

	public Integer getIdMode() {
		return this.idModeProperty().get();
	}
	

	public void setIdMode(Integer idMode) {
		this.idMode = new SimpleIntegerProperty(idMode);
	}
	

	public StringProperty libelleProperty() {
		return this.libelle;
	}
	

	public String getLibelle() {
		return this.libelleProperty().get();
	}
	

	public final void setLibelle(String libelle) {
		this.libelle = new SimpleStringProperty(libelle);
	}

}
