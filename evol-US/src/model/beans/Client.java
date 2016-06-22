/**
 * 
 */
package model.beans;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.Validator;
import model.exception.CreateObjectException;

/**
 * @author silnti
 *
 */
public class Client extends Personne{
	
	
	private StringProperty ville;
	private StringProperty pays;
	private StringProperty cbNum;
	private StringProperty cbDateExp;
	private StringProperty cbCode;
	
	/**
	 * Creation d'un client
	 */
	public Client() {
		super();
	}
	
	
	public Client(String nom, String prenom, String adresse,
			String codePostal, String ville, String pays, String login,
			String password, String cbNum,
			String cbDateExp, String cbCode) throws CreateObjectException {
		
		super(nom, prenom, adresse, codePostal, login, password);
		String messageConseil = "Veillez modifier ce champ, puis ressayez à nouveau";
		
		if (!ville.equals("")) {
			this.ville = new SimpleStringProperty(ville);
		}else {
			throw new CreateObjectException("Le champ [ VILLE ] doit être obligatoirement renseigné", messageConseil);
		}
		if (Validator.regexp(pays, Validator.REGEXP_EMAIL)) {
			this.pays = new SimpleStringProperty(pays);
		}else {
			throw new CreateObjectException("Le champ [ EMAIL ] est invalide", messageConseil);
		}
		
		this.cbDateExp = new SimpleStringProperty(cbDateExp);
		this.cbNum = new SimpleStringProperty(cbNum);
		this.cbCode = new SimpleStringProperty(cbCode);
		
	}

	public String getVille() {
		return ville.get();
	}
	
	public StringProperty VilleProperty() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = new SimpleStringProperty(ville);
	}

	public String getPays() {
		return pays.get();
	}
	
	public StringProperty paysProperty() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = new SimpleStringProperty(pays);
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ "+nom.get()+", "+prenom.get()+", "+ville.get()+", "+codePostal.get()+", "+adresse.get()+" ]";
	}


	public StringProperty cbNumProperty() {
		return this.cbNum;
	}

	public String getCbNum() {
		return this.cbNumProperty().get();
	}
	
	public void setCbNum(String cbNum) {
		this.cbNum = new SimpleStringProperty(cbNum);
	}
	
	public StringProperty cbDateExpProperty() {
		return this.cbDateExp;
	}

	public String getCbDateExp() {
		return this.cbDateExpProperty().get();
	}

	public void setCbDateExp(String cbDateExp) {
		this.cbDateExp = new SimpleStringProperty(cbDateExp);
	}

	public StringProperty cbCodeProperty() {
		return this.cbCode;
	}

	public String getCbCode() {
		return this.cbCodeProperty().get();
	}

	public void setCbCode(String cbCode) {
		this.cbCode = new SimpleStringProperty(cbCode);
	}

	
}
