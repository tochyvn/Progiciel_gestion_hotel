package model.beans;

public class PlatCouvert {

	private Plat plat;

	private Couvert couvert;

	/**
	 * 
	 */
	public PlatCouvert() {
		super();
	}

	/**
	 * @param plat
	 * @param couvert
	 */
	public PlatCouvert(Plat plat, Couvert couvert) {
		super();
		this.plat = plat;
		this.couvert = couvert;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Couvert getCouvert() {
		return couvert;
	}

	public void setCouvert(Couvert couvert) {
		this.couvert = couvert;
	}
	
	

}
