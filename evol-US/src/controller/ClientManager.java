package controller;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.Client;
import model.dao.ClientDAO;

public class ClientManager {

	private static ClientManager instance = null;
	private ClientDAO clientDAO;

	private ClientManager() {
		clientDAO = new ClientDAO(Connexion.getConnexion());
	}
		
	public static ClientManager getInstance() {
		if (instance == null) {
			instance = new ClientManager();
		}
		return instance;
	}
	
	public void findAll(ObservableList<Client> arrayList) {
		clientDAO.findAll(arrayList);
	}
	
	public int create(Client client) {
		return clientDAO.create(client);
	}
	
	public int update(Client client) {
		return clientDAO.update(client);
	}
	
	public int delete(Integer id) {
		return clientDAO.delete(id);
	}
	
	public Client findById(Integer id) {
		return clientDAO.findById(id);
	}

}
