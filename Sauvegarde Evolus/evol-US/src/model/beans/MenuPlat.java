package model.beans;

public class MenuPlat {

	private Plat plat;

	private Menu menu;

	/**
	 * 
	 */
	public MenuPlat() {
		super();
	}

	/**
	 * @param plat
	 * @param menu
	 */
	public MenuPlat(Plat plat, Menu menu) {
		super();
		this.plat = plat;
		this.menu = menu;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
