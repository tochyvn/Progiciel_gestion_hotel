package model.beans;

import model.beans.old.TypeProduit;

//import java.util.Collection;

public class Menu extends TypeProduit {

	
	//private Collection<Plat> menuPlat;

	//private Collection<Couvert> menuCouvert;
	
	public Menu() {
		super();
	}
	
	public Menu(String libelle, double prix) {
		super(libelle, prix);
	}

}
