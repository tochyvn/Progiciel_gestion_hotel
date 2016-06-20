package model.beans;

import model.beans.old.TypeProduit;

//import java.util.Collection;

public class Ingredient extends TypeProduit {
	
	//private Collection<Plat> platIngredient;

	/**
	 * Constructeur sans paramètres
	 */
	public Ingredient() {
		super();
	}

	/**
	 * @param libelle
	 * @param prix
	 */
	public Ingredient(String libelle, double prix) {
		super(libelle, prix);
	}

}
