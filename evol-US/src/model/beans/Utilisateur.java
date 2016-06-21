package model.beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.exception.CreateObjectException;

public class Utilisateur extends Personne {

	private UserPosteDirection poste;
	private DoubleProperty salaire;
	
	
	public Utilisateur() {
		super();
	}


	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param login
	 * @param password
	 * @param poste
	 */
	public Utilisateur(String nom, String prenom, String adresse, String codePostal, String login,
			String password, UserPosteDirection poste, Double salaire) throws CreateObjectException{
		super(nom, prenom, adresse, codePostal, login, password);
		this.setPoste(poste);
		
		String messageConseil = "Veillez modifier ce champ, puis ressayez à nouveau";
		if (salaire != 0) {
			this.salaire = new SimpleDoubleProperty(salaire);
		}else {
			throw new CreateObjectException("Le champ [ SALAIRE ] doit être obligatoirement renseigné", messageConseil);
		}
	}


	public UserPosteDirection getPoste() {
		return poste;
	}


	public void setPoste(UserPosteDirection poste) {
		this.poste = poste;
	}


	public final DoubleProperty salaireProperty() {
		return this.salaire;
	}
	


	public final double getSalaire() {
		return this.salaireProperty().get();
	}
	


	public final void setSalaire(final double salaire) {
		this.salaire = new SimpleDoubleProperty(salaire);
	}
	
	
	

}
