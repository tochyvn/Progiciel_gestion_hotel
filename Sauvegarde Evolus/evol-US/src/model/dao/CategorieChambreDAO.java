/**
 * 
 */
package model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;

/**
 * @author silnti
 *
 */
public class CategorieChambreDAO extends DAO<CategorieChambreDAO> {

	public CategorieChambreDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(CategorieChambreDAO objet) {
		return 0;
	}

	@Override
	public int update(CategorieChambreDAO objet) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public CategorieChambreDAO findById(Integer id) {
		return null;
	}

	@Override
	public void findAll(ObservableList<CategorieChambreDAO> arrayList) {
		
	}

}


