package model.beans;

import model.beans.old.TypeProduit;

//import java.util.Collection;

public class Plat extends TypeProduit {

	
	//private Collection<Menu> menuPlat;

	//private Collection<Couvert> platCouvert;

	//private Collection<Ingredient> platIngredient;

	/**
	 * 
	 */
	public Plat() {
		super();
	}

	/**
	 * @param libelle
	 * @param prix
	 */
	public Plat(String libelle, double prix) {
		super(libelle, prix);
	}
	
	

}
