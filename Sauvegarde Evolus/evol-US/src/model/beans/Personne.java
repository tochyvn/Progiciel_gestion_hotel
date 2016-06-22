package model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.Validator;
import model.exception.CreateObjectException;

public abstract class Personne {

	protected IntegerProperty id;
	protected StringProperty nom;
	protected StringProperty prenom;
	protected StringProperty adresse;
	protected StringProperty codePostal;
	protected StringProperty login;
	protected StringProperty password;
	
	
	public Personne() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param login
	 * @param password
	 */
	public Personne(String nom, String prenom, String adresse, String codePostal, String login,
			String password) throws CreateObjectException{
		super();
		
		String messageConseil = "Veillez modifier ce champ, puis ressayez à nouveau";
		if (!nom.equals("")) {
			this.nom = new SimpleStringProperty(nom);
		}else {
			throw new CreateObjectException("Le champ [ NOM ] doit être obligatoirement renseigné", messageConseil);
		}
		if (!prenom.equals("")) {
			this.prenom = new SimpleStringProperty(prenom);
		}else {
			throw new CreateObjectException("Le champ [ PRENOM ] doit être obligatoirement renseigné", messageConseil);
		}
		if (!adresse.equals("")) {
			this.adresse = new SimpleStringProperty(adresse);
		}else {
			throw new CreateObjectException("Le champ [ ADRESSE ] doit être obligatoirement renseigné", messageConseil);
		}
		if (Validator.hasLength(codePostal, 5)) {
			this.codePostal = new SimpleStringProperty(codePostal);
		}else {
			throw new CreateObjectException("Le champ [ CODE POSTAL ] doit comporter 5 caractères", messageConseil);
		}
		
		if (!login.equals("")) {
			this.login = new SimpleStringProperty(login);
		}else {
			throw new CreateObjectException("Le champ [ LOGIN ] doit être obligatoirement renseigné", messageConseil);
		}
		if (!Validator.lengthIsLowerThan(password, 8)) {
			this.password = new SimpleStringProperty(password);
		}else {
			throw new CreateObjectException("Le champ [ PASSWORD ] doit contenir au moins 8 caractères", messageConseil);
		}
	}


	public void setId(Integer id) {
		this.id = new SimpleIntegerProperty(id);
	}

	public Integer getId() {
		return this.id.get();
	}
	
	public IntegerProperty idProperty() {
		return this.id;
	}

	public void setNom(String nom) {
		this.nom = new SimpleStringProperty(nom);
	}

	public String getNom() {
		return this.nom.get();
	}
	
	public StringProperty nomProperty() {
		return this.nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = new SimpleStringProperty(prenom);
	}

	public String getPrenom() {
		return this.prenom.get();
	}
	
	public StringProperty prenomProperty() {
		return this.prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = new SimpleStringProperty(adresse);
	}

	public String getAdresse() {
		return this.adresse.get();
	}
	
	public StringProperty adresseProperty() {
		return this.adresse;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = new SimpleStringProperty(codePostal);
	}

	public String getCodePostal() {
		return this.codePostal.get();
	}
	
	public StringProperty codePostalProperty() {
		return this.codePostal;
	}

	public void setLogin(String login) {
		this.login = new SimpleStringProperty(login);
	}

	public String getLogin() {
		return this.login.get();
	}
	
	public StringProperty loginProperty() {
		return this.login;
	}

	public void setPassword(String password) {
		this.password = new SimpleStringProperty(password);
	}

	public String getPassword() {
		return password.get();
	}
	
	public StringProperty passwordProperty() {
		return password;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ LOGIN : "+this.login+" PASSWD : "+this.password+" }";
	}
	
	

}
