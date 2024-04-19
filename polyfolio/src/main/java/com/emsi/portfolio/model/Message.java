package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String contenu;
	private Date dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @OnDelete(action= OnDeleteAction.CASCADE)
	@JoinColumn(name = "emetteur_id", referencedColumnName = "id")
	private Utilisateur emetteur;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @OnDelete(action= OnDeleteAction.CASCADE)
	@JoinColumn(name = "recepteur_id", referencedColumnName = "id")
	private Utilisateur recepteur;
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
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	@JsonBackReference(value="message-emetteur")
	public Utilisateur getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Utilisateur emetteur) {
		this.emetteur = emetteur;
	}
	@JsonBackReference(value="message-recepteur")
	public Utilisateur getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(Utilisateur recepteur) {
		this.recepteur = recepteur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", contenu=" + contenu + ", dateTime=" + dateTime + ", emetteur=" + emetteur
				+ ", recepteur=" + recepteur + "]";
	}
	
	
	

}
