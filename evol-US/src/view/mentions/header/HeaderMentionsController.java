package view.mentions.header;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApplication;
import javafx.beans.property.DoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import library.Animation;
import library.LoaderOfScene;
import view.ViewInterfaceConstante;

public class HeaderMentionsController implements Initializable {
		
	private Parent root;

	public HeaderMentionsController() {
		root = MainApplication.primaryStage.getScene().getRoot();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	
	
	private void desactivateStyle() {
		
	}

}
