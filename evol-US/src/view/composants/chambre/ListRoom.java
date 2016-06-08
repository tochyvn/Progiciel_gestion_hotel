package view.composants.chambre;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import model.beans.Chambre1;

public class ListRoom extends FlowPane {
	
	private ObservableList<BoxRoom> rooms;
	//La chambre selectionn�e dans la liste de chambre
	public static Chambre1 roomSelected;

	
	public ListRoom() {
		rooms = FXCollections.observableArrayList();
	}

	public ListRoom(Orientation orientation) {
		super(orientation);
	}

	public ListRoom(ArrayList<Chambre1> chambres) {
		this.rooms = FXCollections.observableArrayList();
		this.setStyle("-fx-background-color: #D5F0D5;");
		this.putRoom(chambres);
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
	private void putRoom(ArrayList<Chambre1> chambres) {
		for (Chambre1 chambre : chambres) {
			BoxRoom boxRoom = new BoxRoom(chambre);
			this.getChildren().add(boxRoom);
			//Ici on met une marge entre les diff�rentes BoxRoom <====> Chambre
			setMargin(boxRoom, new Insets(20, 10, 10, 20));
		}
	}
	

}
