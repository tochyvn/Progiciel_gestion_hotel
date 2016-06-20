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
public class ClientChambre extends DAO<model.beans.old.ClientChambre> {

	public ClientChambre(Connection conn) {
		super(conn);
	}

	@Override
	public int create(model.beans.old.ClientChambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(model.beans.old.ClientChambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public model.beans.old.ClientChambre findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<model.beans.old.ClientChambre> arrayList) {
		// TODO Auto-generated method stub
		
	}

}
