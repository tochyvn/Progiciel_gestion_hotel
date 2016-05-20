import java.util.Collection;

public class Chambre {

	private int idChambre;

	private String surface;

	private String telephone;

	private String etage;

	private String nbrePlace;

	private boolean douche;

	private boolean baignoire;

	private boolean fumeur;

	private int prix;

	private CategorieChambre categorie;

	private Collection<DemandeReservation> demandeReservation;

	private Collection<Date> tarif;

	private Etat etat;

	private Collection<Reparation> reparation;

	public void setIdChambre(int idChambre) {

	}

	public int getIdChambre() {
		return 0;
	}

	public void setSurface(String surface) {

	}

	public String getSurface() {
		return null;
	}

	public void setTelephone(String telephone) {

	}

	public String getTelephone() {
		return null;
	}

	public void setTelephone(String telephone) {

	}

	public void setEtage(String etage) {

	}

	public String getEtage() {
		return null;
	}

	public void setDouche(boolean douche) {

	}

	public boolean isDouche() {
		return false;
	}

	public void setBaignoire(boolean baignoire) {

	}

	public boolean isBaignoire() {
		return false;
	}

	public void setFumeur(boolean fumeur) {

	}

	public boolean isFumeur() {
		return false;
	}

	public void setPrix(int prix) {

	}

	public int getPrix() {
		return 0;
	}

}
