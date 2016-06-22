package model.beans;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.Validator;
import model.exception.CreateObjectException;

public class Utilisateur extends Personne {

	private UserPosteDirection poste;
	private StringProperty salaire;
	
	
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
			String password, UserPosteDirection poste, String salaire) throws CreateObjectException{
		super(nom, prenom, adresse, codePostal, login, password);
		this.setPoste(poste);
		
		String messageConseil = "Veillez modifier ce champ, puis ressayez à nouveau";
		if (!salaire.equals("") && Validator.validateNombre(salaire)) {
			this.salaire = new SimpleStringProperty(salaire);
		}else {
			throw new CreateObjectException("Le champ [ SALAIRE ] doit être au format numérique ", messageConseil);
		}
	}


	public UserPosteDirection getPoste() {
		return poste;
	}


	public void setPoste(UserPosteDirection poste) {
		this.poste = poste;
	}


	public final StringProperty salaireProperty() {
		return this.salaire;
	}
	


	public final String getSalaire() {
		return this.salaireProperty().get();
	}
	


	public final void setSalaire(final String salaire) {
		this.salaire = new SimpleStringProperty(salaire);
	}
	
	
	

}
