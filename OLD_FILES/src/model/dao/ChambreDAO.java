/**
 * 
 */
package model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.beans.Chambre;

/**
 * @author silnti
 *
 */
public class ChambreDAO extends DAO<Chambre> {

	public ChambreDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Chambre objet) {
		return 0;
	}

	@Override
	public int update(Chambre objet) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public Chambre findById(Integer id) {
		return null;
	}

	@Override
	public void findAll(ObservableList<Chambre> arrayList) {
		
	}
	
	

}
