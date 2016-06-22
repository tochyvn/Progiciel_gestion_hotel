package model.beans;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class LivreOr {
	private IntegerProperty idLivreOr;
	private Date dateCommentaire;
	private String nomClient;
	private String commentaire;
	
	public LivreOr() {
		super();
	}
	
	public LivreOr(LocalDate date, String nomClient, String commentaire) {
		super();
		this.setDateCommentaire(dateCommentaire);
		this.setNomClient(nomClient);
		this.setCommentaire(commentaire);
	}

	public IntegerProperty getIdLivreOr() {
		return idLivreOr;
	}

	public void setIdLivreOr(Integer idLivreOr) {
		this.idLivreOr = new SimpleIntegerProperty(idLivreOr);
	}
	
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
}
