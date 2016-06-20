/**
 * 
 */
package model.beans.old;

import model.beans.Chambre;
import model.beans.Client;

/**
 * @author silnti
 *
 */
public class ClientChambre {
	
	private Client client;
	private Chambre chambre;

	/**
	 * 
	 */
	public ClientChambre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param client
	 * @param chambre
	 */
	public ClientChambre(Client client, Chambre chambre) {
		super();
		this.client = client;
		this.chambre = chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	

}
