package model.exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//import javax.swing.JOptionPane;

public class CreateObjectException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String errorMessage;

	public CreateObjectException(String message, String errorMessage) {
		super();
		this.message = message;
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Methode permettant d'afficher les messages d'erreurs dans une boîte de dialogue
	 */
	public void showError() {
		System.out.println("tochap ta fonction a fonctionnée");
		Alert dialog = new Alert(AlertType.ERROR);
		dialog.setTitle("Erreur"); 
		dialog.setHeaderText(this.message);
		dialog.setContentText(this.errorMessage);
		dialog.showAndWait();
	}

}
