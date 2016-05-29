package model.beans;

public class MenuCouvert {

	private Menu menu;

	private Couvert couvert;

	/**
	 * 
	 */
	public MenuCouvert() {
		super();
	}

	/**
	 * @param menu
	 * @param couvert
	 */
	public MenuCouvert(Menu menu, Couvert couvert) {
		super();
		this.menu = menu;
		this.couvert = couvert;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Couvert getCouvert() {
		return couvert;
	}

	public void setCouvert(Couvert couvert) {
		this.couvert = couvert;
	}

	

}
