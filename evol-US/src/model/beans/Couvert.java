package model.beans;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;
//import java.util.Collection;

public class Couvert extends Produit {

	private ObjectProperty<LocalDate> horaire;

	//private Collection<Plat> platCouvert;

	//private Collection<Menu> menuCouvert;

	public void setHoraire(LocalDate horaire) {
		this.horaire = new SimpleObjectProperty<LocalDate>(horaire);
	}

	public LocalDate getHoraire() {
		return this.horaire.get();
	}
	
	public ObjectProperty<LocalDate> horaireProperty() {
		return this.horaire;
	}

}
