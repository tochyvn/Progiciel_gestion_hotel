package view.composants.alerte;

import javafx.scene.control.Alert;

public class AlertWarning extends Alert {

	public AlertWarning(String header, String context) {
		super(AlertType.WARNING);
		this.setTitle("ATTENTION");
		this.setHeaderText(header);
		this.setContentText(context);
	}

}
