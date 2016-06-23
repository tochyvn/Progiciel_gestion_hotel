package controller;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.LivreOr;
import model.dao.LivreOrDAO;

public class LivreOrManager {

	private static LivreOrManager instance = null;
	private LivreOrDAO LivreOrDAO;
	
	private LivreOrManager() {
		LivreOrDAO = new LivreOrDAO(Connexion.getConnexion());
	}
	
	public static LivreOrManager getInstance() {
		if(instance == null) {
			instance = new LivreOrManager();
		}
		return instance;
	}
	
	public void findAll(ObservableList<LivreOr> arrayList) {
		LivreOrDAO.findAll(arrayList);
	}
	
	public ObservableList<LivreOr> findAll() {
		return LivreOrDAO.findAll();
	}
	
	public int create(LivreOr LivreOr) {
		return LivreOrDAO.create(LivreOr);
	}
	
	
}
