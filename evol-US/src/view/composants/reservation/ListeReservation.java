package view.composants.reservation;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import model.beans.Reservation;

public class ListeReservation extends FlowPane{
	
	private ObservableList<BoxReservation> reservations;
	//La chambre selectionn�e dans la liste de chambre
	public static Reservation reservationSelected;

	
	public ListeReservation() {
		reservations = FXCollections.observableArrayList();
	}

	public ListeReservation(Orientation orientation) {
		super(orientation);
	}

	public ListeReservation(ArrayList<Reservation> chambres) {
		this.reservations = FXCollections.observableArrayList();
		this.setStyle("-fx-background-color: #D5F0D5;");
		this.putRoom(chambres);
	}
	
	/**
	 * Permet d'ajouter chaque chambre dans le composant liste de chambre
	 */
	public void setItems(ObservableList<BoxReservation> reservations) {
		for (BoxReservation reservation : reservations) {
			this.getChildren().add(reservation);
		}
	}
	/**
	 * Ajouter une BoxRoom à la liste observable de BoxRoom
	 * @param boxRoom la room à ajouter
	 * @return Retourne la BoxRoom ajoutée
	 */
	public boolean addItem(BoxReservation reservation) {
		return this.reservations.add(reservation);
	}
	
	/**
	 * Methode qui prend en paramètre une arraylist de room et remplis la liste de Room
	 * @param chambres
	 */
	private void putRoom(ArrayList<Reservation> reservations) {
		for (Reservation reservation : reservations) {
			BoxReservation boxReservation = new BoxReservation(reservation);
			this.getChildren().add(boxReservation);
			//Ici on met une marge entre les diff�rentes BoxRoom <====> Chambre
			setMargin(boxReservation, new Insets(20, 10, 10, 20));
		}
	}
	
}
