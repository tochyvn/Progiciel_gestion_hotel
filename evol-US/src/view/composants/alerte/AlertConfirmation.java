package view.composants;

import javafx.scene.control.Alert;

/**
 * @author silnti
 *
 */
public class AlertConfirmation extends Alert {

	public AlertConfirmation(String header, String context) {
		super(AlertType.CONFIRMATION);
		this.setTitle("Confirmation");
		this.setHeaderText(header);
		this.setContentText(context);
	}
	
}
