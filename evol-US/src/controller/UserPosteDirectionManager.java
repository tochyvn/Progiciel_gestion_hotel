package controller;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.UserPosteDirection;
import model.dao.UserPosteDirectionDAO;

public class UserPosteDirectionManager {
	
	private static UserPosteDirectionManager instance = null;
	private UserPosteDirectionDAO userPosteDAO;

	private UserPosteDirectionManager() {
		userPosteDAO = new UserPosteDirectionDAO(Connexion.getConnexion());
	}
	
	public void findAll(ObservableList<UserPosteDirection> arrayList) {
		userPosteDAO.findAll(arrayList);
	}
	
	public static UserPosteDirectionManager getInstance() {
		if (instance == null) {
			instance = new UserPosteDirectionManager();
		}
		return instance;
	}

}
