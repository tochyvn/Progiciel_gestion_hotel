package view.composants;

import javafx.scene.control.Alert;

public class AlertInfo extends Alert {

	public AlertInfo(String header, String context) {
		super(AlertType.INFORMATION);
		this.setTitle("INFORMATION");
		this.setHeaderText(header);
		this.setContentText(context);
	}

}
