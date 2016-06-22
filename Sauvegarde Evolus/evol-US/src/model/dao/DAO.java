package model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;

/**
 * @author silnti
 *
 */
public abstract class DAO<T> {
	
	protected Connection connexion = null;

	/**
	 * Constructeur instanciant une connexion
	 */
	public DAO(Connection conn) {
		this.connexion = conn;
	}
	
	/**
	 * Creation d'objet de type T
	 * @param objet
	 * @return
	 */
	public abstract int create(T objet);
	
	public abstract int update(T objet);
	
	public abstract int delete(Integer id);
	
	public abstract T findById(Integer id);
	
	public abstract void findAll(ObservableList<T> arrayList);

}
