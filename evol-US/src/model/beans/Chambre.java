package model.beans;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.beans.old.ConfirmationReservation;
import model.beans.old.DemandeReservation;

//import java.util.Collection;

public class Chambre {

	private IntegerProperty idChambre;
	private StringProperty surface;
	private StringProperty telephone;
	private StringProperty etage;
	private IntegerProperty nbrePlace;
	private IntegerProperty douche;
	private IntegerProperty baignoire;
	private IntegerProperty fumeur;
	private DoubleProperty prix;
	private DoubleProperty tva;
	private EtatChambre etat;
	private StringProperty categorie;
	public static double TVA = 0.75;
	
	public static HashMap<Integer , ArrayList<DemandeReservation>> demandes;
	public static HashMap<Integer, ArrayList<ConfirmationReservation>> reservations;

	/**
	 * 
	 */
	public Chambre() {
		super();
	}

	/**
	 * @param idChambre
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
	public Chambre(String surface, String telephone, String etage, Integer nbrePlace, Integer douche, Integer baignoire,
			Integer fumeur, Double prix, String categorie) {
		super();
		this.surface = new SimpleStringProperty(surface);
		this.telephone = new SimpleStringProperty(telephone);
		this.etage = new SimpleStringProperty(etage);
		this.nbrePlace = new SimpleIntegerProperty(nbrePlace);
		this.douche = new SimpleIntegerProperty(douche);
		this.baignoire = new SimpleIntegerProperty(baignoire);
		this.fumeur = new SimpleIntegerProperty(fumeur);
		this.prix = new SimpleDoubleProperty(prix);
		this.categorie = new SimpleStringProperty(categorie);
		this.tva = new SimpleDoubleProperty(TVA);
		this.etat = EtatChambre.LIBRE;
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
	

	public IntegerProperty nbrePlaceProperty() {
		return this.nbrePlace;
	}
	

	public Integer getNbrePlace() {
		return this.nbrePlaceProperty().get();
	}
	

	public void setNbrePlace(Integer nbrePlace) {
		this.nbrePlace = new SimpleIntegerProperty(nbrePlace);
	}
	

	public IntegerProperty doucheProperty() {
		return this.douche;
	}
	

	public Integer isDouche() {
		return this.doucheProperty().get();
	}
	

	public void setDouche(Integer douche) {
		this.douche = new SimpleIntegerProperty(douche);
	}
	

	public final IntegerProperty baignoireProperty() {
		return this.baignoire;
	}
	

	public Integer isBaignoire() {
		return this.baignoireProperty().get();
	}
	

	public void setBaignoire(Integer baignoire) {
		this.baignoire = new SimpleIntegerProperty(baignoire);
	}
	

	public IntegerProperty fumeurProperty() {
		return this.fumeur;
	}
	

	public Integer isFumeur() {
		return this.fumeurProperty().get();
	}
	

	public void setFumeur(Integer fumeur) {
		this.fumeur = new SimpleIntegerProperty(fumeur);
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

	public final DoubleProperty tvaProperty() {
		return this.tva;
	}
	
	public final double getTva() {
		return this.tvaProperty().get();
	}
	
	public final void setTva(final double tva) {
		this.tva = new SimpleDoubleProperty(tva);
	}
	
	public static EtatChambre getEtatChambreEnum(String etat) {
		EtatChambre etatEnum = null;
		if(etat.equals("OCCUPEE")) {
			etatEnum = EtatChambre.OCCUPEE;
		}else if (etat.equals("MAINTENANCE")) {
			etatEnum = EtatChambre.MAINTENANCE;
		}else if (etat.equals("LIBRE")){
			etatEnum = EtatChambre.LIBRE;
		}
		
		return etatEnum;
	}

	@Override
	public String toString() {
		return "NUM : "+idChambre.get()+" SURFACE : "+surface.get();
	}
	
	public String getFumeurAffiche() {
		String fumeur = null;
		if (isFumeur() == 0) {
			fumeur = "NON";
		}else if(isFumeur() == 1) {
			fumeur = "OUI";
		}
		
		return fumeur;
	}
	
	public String getBaignoireAffiche() {
		String baignoire = null;
		if (isBaignoire() == 0) {
			baignoire = "NON";
		}else if(isBaignoire() == 1) {
			baignoire = "OUI";
		}
		
		return baignoire;
	}
	
	public String getDoucheAffiche() {
		String baignoire = null;
		if (isDouche() == 0) {
			baignoire = "NON";
		}else if(isDouche() == 1) {
			baignoire = "OUI";
		}
		
		return baignoire;
	}

	public final StringProperty categorieProperty() {
		return this.categorie;
	}
	

	public final java.lang.String getCategorie() {
		return this.categorieProperty().get();
	}
	

	public final void setCategorie(final java.lang.String categorie) {
		this.categorie = new SimpleStringProperty(categorie);
	}

}
