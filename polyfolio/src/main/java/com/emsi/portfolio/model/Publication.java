package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private String type;
	private String visibilite;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="publication", cascade=CascadeType.ALL)
	private List<Like> likes;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="publication", cascade=CascadeType.ALL)
	private List<Partage> partages;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="publication", cascade=CascadeType.ALL)
	private List<Commentaire> commentaires;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="publication", cascade=CascadeType.ALL)
	private List<Media> medias;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="publication", cascade=CascadeType.ALL)
	private List<Notification> notifications;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @OnDelete(action= OnDeleteAction.CASCADE)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Partage> getPartages() {
		return partages;
	}

	public void setPartages(List<Partage> partages) {
		this.partages = partages;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", description=" + description + ", type=" + type + ", visibilite="
				+ visibilite + ", likes=" + likes + ", partages=" + partages + ", commentaires=" + commentaires
				+ ", medias=" + medias + ", notifications=" + notifications + "]";
	}

	
}
