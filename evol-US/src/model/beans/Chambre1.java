package model.beans;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//import java.util.Collection;

public class Chambre1 {

	private IntegerProperty idChambre;
	private StringProperty surface;
	private StringProperty telephone;
	private StringProperty etage;
	private StringProperty nbrePlace;
	private BooleanProperty douche;
	private BooleanProperty baignoire;
	private BooleanProperty fumeur;
	private DoubleProperty prix;
	private EtatChambre etat;
	private CategorieChambre1 categorie;
	
	public static HashMap<Integer , ArrayList<DemandeReservation>> demandes;
	public static HashMap<Integer, ArrayList<ConfirmationReservation>> reservations;

	/**
	 * 
	 */
	public Chambre1() {
		super();
	}

	/**
	 * @param surface
	 * @param telephone
	 * @param etage
	 * @param nbrePlace
	 * @param douche
	 * @param baignoire
	 * @param fumeur
	 * @param prix
	 * @param etat
	 * @param categorie
	 */
	public Chambre1(String surface, String telephone, String etage, String nbrePlace, Boolean douche, Boolean baignoire,
			Boolean fumeur, Double prix, CategorieChambre1 categorie) {
		super();
		this.surface = new SimpleStringProperty(surface);
		this.telephone = new SimpleStringProperty(telephone);
		this.etage = new SimpleStringProperty(etage);
		this.nbrePlace = new SimpleStringProperty(nbrePlace);
		this.douche = new SimpleBooleanProperty(douche);
		this.baignoire = new SimpleBooleanProperty(baignoire);
		this.fumeur = new SimpleBooleanProperty(fumeur);
		this.prix = new SimpleDoubleProperty(prix);
		this.etat = EtatChambre.LIBRE;
		this.categorie = categorie;
		this.idChambre = new SimpleIntegerProperty(new Integer(10)); 
	}

	public final IntegerProperty idChambreProperty() {
		return this.idChambre;
	}
	

	public Integer getIdChambre() {
		return this.idChambreProperty().get();
	}
	

	public final void setIdChambre(Integer idChambre) {
		this.idChambre = new SimpleIntegerProperty(idChambre);
	}
	

	public StringProperty surfaceProperty() {
		return this.surface;
	}
	

	public String getSurface() {
		return this.surfaceProperty().get();
	}
	

	public void setSurface(String surface) {
		this.surface = new SimpleStringProperty(surface);
	}
	

	public StringProperty telephoneProperty() {
		return this.telephone;
	}
	

	public String getTelephone() {
		return this.telephoneProperty().get();
	}
	

	public void setTelephone(String telephone) {
		this.telephone = new SimpleStringProperty(telephone);
	}
	

	public StringProperty etageProperty() {
		return this.etage;
	}
	

	public String getEtage() {
		return this.etageProperty().get();
	}
	

	public void setEtage(String etage) {
		this.etage = new SimpleStringProperty(etage);
	}
	

	public StringProperty nbrePlaceProperty() {
		return this.nbrePlace;
	}
	

	public String getNbrePlace() {
		return this.nbrePlaceProperty().get();
	}
	

	public void setNbrePlace(String nbrePlace) {
		this.nbrePlace = new SimpleStringProperty(nbrePlace);
	}
	

	public BooleanProperty doucheProperty() {
		return this.douche;
	}
	

	public Boolean isDouche() {
		return this.doucheProperty().get();
	}
	

	public void setDouche(Boolean douche) {
		this.doucheProperty().set(douche);
	}
	

	public final BooleanProperty baignoireProperty() {
		return this.baignoire;
	}
	

	public Boolean isBaignoire() {
		return this.baignoireProperty().get();
	}
	

	public void setBaignoire(Boolean baignoire) {
		this.baignoire = new SimpleBooleanProperty(baignoire);
	}
	

	public BooleanProperty fumeurProperty() {
		return this.fumeur;
	}
	

	public boolean isFumeur() {
		return this.fumeurProperty().get();
	}
	

	public void setFumeur(Boolean fumeur) {
		this.fumeur = new SimpleBooleanProperty(fumeur);
	}
	

	public DoubleProperty prixProperty() {
		return this.prix;
	}
	

	public Double getPrix() {
		return this.prixProperty().get();
	}
	

	public void setPrix(Double prix) {
		this.prix = new SimpleDoubleProperty(prix);
	}

	public EtatChambre getEtat() {
		return etat;
	}

	public void setEtat(EtatChambre etat) {
		this.etat = etat;
	}

	public CategorieChambre1 getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieChambre1 categorie) {
		this.categorie = categorie;
	}
	
	

}
