package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Notification implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String titre;
private String message;
private Boolean lu;
//date time notification
private Date date;

@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
@JsonBackReference
@OnDelete(action= OnDeleteAction.CASCADE)
@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
private Utilisateur utilisateur;

@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
@JsonBackReference
@OnDelete(action= OnDeleteAction.CASCADE)
@JoinColumn(name = "publication_id", referencedColumnName = "id")
private Publication publication;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Boolean getLu() {
	return lu;
}
public void setLu(Boolean lu) {
	this.lu = lu;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public Publication getPublication() {
	return publication;
}
public void setPublication(Publication publication) {
	this.publication = publication;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Notification [id=" + id + ", titre=" + titre + ", message=" + message + ", lu=" + lu + ", date=" + date
			+ ", utilisateur=" + utilisateur + ", publication=" + publication + "]";
}


}
