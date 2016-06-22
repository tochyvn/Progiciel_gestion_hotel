package model.beans;

public class PlatIngredient {

	private Plat plat;

	private Ingredient ingredient;

	/**
	 * 
	 */
	public PlatIngredient() {
		super();
	}

	/**
	 * @param plat
	 * @param ingredient
	 */
	public PlatIngredient(Plat plat, Ingredient ingredient) {
		super();
		this.plat = plat;
		this.ingredient = ingredient;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	

}
