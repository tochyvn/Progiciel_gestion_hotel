package controller;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.Reservation;
import model.dao.ReservationDAO;

public class ReservationManager {

	private static ReservationManager instance = null;
	private ReservationDAO ReservationDAO;

	private ReservationManager() {
		ReservationDAO = new ReservationDAO(Connexion.getConnexion());
	}
		
	public static ReservationManager getInstance() {
		if (instance == null) {
			instance = new ReservationManager();
		}
		return instance;
	}
	
	public void findAll(ObservableList<Reservation> arrayList) {
		ReservationDAO.findAll(arrayList);
	}
	
	public ObservableList<Reservation> findAll() {
		return ReservationDAO.findAll();
	}
	
	public int create(Reservation Reservation) {
		return ReservationDAO.create(Reservation);
	}
	
	public int update(Reservation Reservation) {
		return ReservationDAO.update(Reservation);
	}
	
	public int delete(Integer id) {
		return ReservationDAO.delete(id);
	}
	
	public Reservation findById(Integer id) {
		return ReservationDAO.findById(id);
	}

}
