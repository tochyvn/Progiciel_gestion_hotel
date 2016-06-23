package controller;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.Chambre;
import model.dao.ChambreDAO;

public class ChambreManager {

	private static ChambreManager instance = null;
	private ChambreDAO ChambreDAO;

	private ChambreManager() {
		ChambreDAO = new ChambreDAO(Connexion.getConnexion());
	}
		
	public static ChambreManager getInstance() {
		if (instance == null) {
			instance = new ChambreManager();
		}
		return instance;
	}
	
	public void findAll(ObservableList<Chambre> arrayList) {
		ChambreDAO.findAll(arrayList);
	}
	
	public ObservableList<Chambre> findAll() {
		return ChambreDAO.findAll();
	}
	
	public int create(Chambre Chambre) {
		return ChambreDAO.create(Chambre);
	}
	
	public int update(Chambre Chambre) {
		return ChambreDAO.update(Chambre);
	}
	
	public int delete(Integer id) {
		return ChambreDAO.delete(id);
	}
	
	public Chambre findById(Integer id) {
		return ChambreDAO.findById(id);
	}

	public int countRoom (String etat) {
	
		return ChambreDAO.countRoom(etat);
		
	}
	
	public int countAll () {
		
		return ChambreDAO.countAll();
		
	}
}
