package view.composants.alerte;

import javafx.scene.control.Alert;

public class AlertError extends Alert {
	
	public AlertError(String header, String context) {
		super(AlertType.ERROR);
		this.setTitle("Attention");
		this.setHeaderText(header);
		this.setContentText(context);
	}

}
