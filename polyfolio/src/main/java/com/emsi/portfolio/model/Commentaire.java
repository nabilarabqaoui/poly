package com.emsi.portfolio.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Commentaire implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String contenu;

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
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
@JsonBackReference(value="commentaire-utilisateur")
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
@JsonBackReference(value="commentaire-publication")
public Publication getPublication() {
	return publication;
}
public void setPublication(Publication publication) {
	this.publication = publication;
}
@Override
public String toString() {
	return "Commentaire [id=" + id + ", contenu=" + contenu + ", utilisateur=" + utilisateur + ", publication="
			+ publication + "]";
}


}
