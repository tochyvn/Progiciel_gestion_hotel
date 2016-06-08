package view.composants.chambre;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import model.beans.Chambre;

public class ListRoom extends FlowPane {
	
	private ObservableList<BoxRoom> rooms;
	private ScrollPane parentScrollPane;
	//La chambre selectionn�e dans la liste de chambre
	public static Chambre roomSelected;

	
	public ListRoom() {
		rooms = FXCollections.observableArrayList();
	}

	public ListRoom(Orientation orientation) {
		super(orientation);
	}

	public ListRoom(ArrayList<Chambre> chambres) {
		this(Orientation.HORIZONTAL);
		this.rooms = FXCollections.observableArrayList();
		this.putRoom(chambres);
		//Ajouter une barre de defilement
		parentScrollPane = new ScrollPane(this);
		//Pour faire son enfant matcher la taille de son parent
		parentScrollPane.setFitToHeight(true);
		parentScrollPane.setFitToWidth(true);
	}
	
	/**
	 * Permet d'ajouter chaque chambre dans le composant liste de chambre
	 */
	public void setItems(ObservableList<BoxRoom> rooms) {
		for (BoxRoom boxRoom : rooms) {
			this.getChildren().add(boxRoom);
		}
	}
	/**
	 * Ajouter une BoxRoom à la liste observable de BoxRoom
	 * @param boxRoom la room à ajouter
	 * @return Retourne la BoxRoom ajoutée
	 */
	public boolean addItem(BoxRoom boxRoom) {
		return this.rooms.add(boxRoom);
	}
	
	/**
	 * Methode qui prend en paramètre une arraylist de room et remplis la liste de Room
	 * @param chambres
	 */
	private void putRoom(ArrayList<Chambre> chambres) {
		for (Chambre chambre : chambres) {
			BoxRoom boxRoom = new BoxRoom(chambre);
			this.getChildren().add(boxRoom);
			//Ici on met une marge entre les diff�rentes BoxRoom <====> Chambre
			setMargin(boxRoom, new Insets(20, 10, 10, 20));
		}
	}
	
	public ScrollPane getParentScrollPane() {
		return parentScrollPane;
	}

}
