package model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.beans.Reservation;

public class ReservationDAO extends DAO<Reservation> {

	public ReservationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Reservation objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Reservation objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reservation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<Reservation> arrayList) {
		
	}

	

}
