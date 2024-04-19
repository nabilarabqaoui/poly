package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "publication_like")
public class Like implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	//le nombre des j'aime
	private int nombre;
	
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
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	@JsonBackReference(value="like-utilisateur")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@JsonBackReference(value="like-publication")
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
		return "Like [id=" + id + ", nombre=" + nombre + ", utilisateur=" + utilisateur + ", publication=" + publication
				+ "]";
	}
	
	
	
	
	
}
