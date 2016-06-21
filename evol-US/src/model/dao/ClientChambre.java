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
public class ClientChambre extends DAO<model.beans.ClientChambre> {

	public ClientChambre(Connection conn) {
		super(conn);
	}

	@Override
	public int create(model.beans.ClientChambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(model.beans.ClientChambre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public model.beans.ClientChambre findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<model.beans.ClientChambre> arrayList) {
		// TODO Auto-generated method stub
		
	}

}
