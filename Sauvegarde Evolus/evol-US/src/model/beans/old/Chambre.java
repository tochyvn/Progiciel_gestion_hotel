package model.beans.old;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author silnti
 *
 */
public class Chambre {
	
	private IntegerProperty idChambre;
	private StringProperty surface;
	private StringProperty telephone;
	private IntegerProperty etage;
	private IntegerProperty nbrePlace;
	private IntegerProperty douche;
	private IntegerProperty baignoire;
	private CategorieChambre categorieChambre;

	/**
	 * 
	 */
	public Chambre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idChambre
	 * @param surface
	 * @param telephone
	 * @param etage
	 * @param nbrePlace
	 * @param douche
	 * @param baignoire
	 * @param categorieChambre
	 */
	public Chambre(String surface, String telephone, Integer etage,
			Integer nbrePlace, Integer douche, Integer baignoire,
			CategorieChambre categorieChambre) {
		super();
		this.surface = new SimpleStringProperty(surface);
		this.telephone = new SimpleStringProperty(telephone);
		this.etage = new SimpleIntegerProperty(etage);
		this.nbrePlace = new SimpleIntegerProperty(nbrePlace);
		this.douche = new SimpleIntegerProperty(douche);
		this.baignoire = new SimpleIntegerProperty(baignoire);
		this.setCategorieChambre(categorieChambre);
	}

	public final IntegerProperty idChambreProperty() {
		return this.idChambre;
	}
	

	public final int getIdChambre() {
		return this.idChambreProperty().get();
	}
	

	public final void setIdChambre(final int idChambre) {
		this.idChambreProperty().set(idChambre);
	}
	

	public final StringProperty surfaceProperty() {
		return this.surface;
	}
	

	public final java.lang.String getSurface() {
		return this.surfaceProperty().get();
	}
	

	public final void setSurface(final java.lang.String surface) {
		this.surfaceProperty().set(surface);
	}
	

	public final StringProperty telephoneProperty() {
		return this.telephone;
	}
	

	public final java.lang.String getTelephone() {
		return this.telephoneProperty().get();
	}
	

	public final void setTelephone(final java.lang.String telephone) {
		this.telephoneProperty().set(telephone);
	}
	

	public final IntegerProperty etageProperty() {
		return this.etage;
	}
	

	public final int getEtage() {
		return this.etageProperty().get();
	}
	

	public final void setEtage(final int etage) {
		this.etageProperty().set(etage);
	}
	

	public final IntegerProperty nbrePlaceProperty() {
		return this.nbrePlace;
	}
	

	public final int getNbrePlace() {
		return this.nbrePlaceProperty().get();
	}
	

	public final void setNbrePlace(final int nbrePlace) {
		this.nbrePlaceProperty().set(nbrePlace);
	}
	

	public final IntegerProperty doucheProperty() {
		return this.douche;
	}
	

	public final int getDouche() {
		return this.doucheProperty().get();
	}
	

	public final void setDouche(final int douche) {
		this.doucheProperty().set(douche);
	}
	

	public final IntegerProperty baignoireProperty() {
		return this.baignoire;
	}
	

	public final int getBaignoire() {
		return this.baignoireProperty().get();
	}
	

	public final void setBaignoire(final int baignoire) {
		this.baignoireProperty().set(baignoire);
	}

	public CategorieChambre getCategorieChambre() {
		return categorieChambre;
	}

	public void setCategorieChambre(CategorieChambre categorieChambre) {
		this.categorieChambre = categorieChambre;
	}

}
