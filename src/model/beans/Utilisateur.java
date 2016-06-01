package model.beans;

import model.exception.CreateObjectException;

public class Utilisateur extends Personne {

	private UserPosteDirection poste;
	
	
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
			String password, UserPosteDirection poste) throws CreateObjectException{
		super(nom, prenom, adresse, codePostal, login, password);
		this.setPoste(poste);
	}


	public UserPosteDirection getPoste() {
		return poste;
	}


	public void setPoste(UserPosteDirection poste) {
		this.poste = poste;
	}

}
