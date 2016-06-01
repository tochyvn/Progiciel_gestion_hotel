/**
 * 
 */
package model.beans;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.exception.CreateObjectException;

/**
 * @author silnti
 *
 */
public class Client extends Personne{
	
	
	private StringProperty ville;
	private StringProperty pays;
	private StringProperty cbNum;
	private ObjectProperty<LocalDate> cbDateExp;
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
			LocalDate cbDateExp, String cbCode) throws CreateObjectException {
		
		super(nom, prenom, adresse, codePostal, login, password);
		String messageConseil = "Veillez modifier ce champ, puis ressayez à nouveau";
		
		if (!ville.equals("")) {
			this.ville = new SimpleStringProperty(ville);
		}else {
			throw new CreateObjectException("Le champ [ VILLE ] doit être obligatoirement renseigné", messageConseil);
		}
		if (!pays.equals("")) {
			this.pays = new SimpleStringProperty(pays);
		}else {
			throw new CreateObjectException("Le champ [ PAYS ] doit être obligatoirement renseigné", messageConseil);
		}
		
		this.cbDateExp = new SimpleObjectProperty<LocalDate>(cbDateExp);
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
	
	public ObjectProperty<LocalDate> cbDateExpProperty() {
		return this.cbDateExp;
	}

	public LocalDate getCbDateExp() {
		return this.cbDateExpProperty().get();
	}

	public void setCbDateExp(LocalDate cbDateExp) {
		this.cbDateExp = new SimpleObjectProperty<LocalDate>(cbDateExp);
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
