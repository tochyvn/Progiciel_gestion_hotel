package model.beans.old;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.beans.Chambre;
import model.beans.Client;

public class ConfirmationReservation extends DemandeReservation {

	private ObjectProperty<LocalDate> dateConfirmation;

	private BooleanProperty confirmation;
	

	/**
	 * 
	 */
	public ConfirmationReservation() {
		super();
	}

	/**
	 * @param dateArrivee
	 * @param dateSortie
	 * @param client
	 * @param chambre
	 */
	public ConfirmationReservation(LocalDate dateArrivee, LocalDate dateSortie, Client client, Chambre chambre,
			LocalDate dateConfirmation, boolean confirmation) {
		super(dateArrivee, dateSortie, client, chambre);
		this.dateConfirmation = new SimpleObjectProperty<LocalDate>(dateConfirmation);
		this.confirmation = new SimpleBooleanProperty(confirmation);
	}

	public ObjectProperty<LocalDate> dateConfirmationProperty() {
		return this.dateConfirmation;
	}
	

	public LocalDate getDateConfirmation() {
		return this.dateConfirmationProperty().get();
	}
	

	public void setDateConfirmation(LocalDate dateConfirmation) {
		this.dateConfirmation = new SimpleObjectProperty<LocalDate>(dateConfirmation);
	}
	

	public final BooleanProperty confirmationProperty() {
		return this.confirmation;
	}
	

	public final boolean isConfirmation() {
		return this.confirmationProperty().get();
	}
	

	public void setConfirmation(boolean confirmation) {
		this.confirmation = new SimpleBooleanProperty(confirmation);
	}

}
