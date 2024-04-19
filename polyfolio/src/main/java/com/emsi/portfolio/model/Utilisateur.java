package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "utilisateur", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
public class Utilisateur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String username;
	private String email;
	private Date dateNaissance;
	private String password;
	private String visibilte;
	private String photoProfil;
	private String typeProfil;
	private String photoCouverture;
	private Boolean estEtudiant;
	private String ecole;
	private String telephone;
	private int anneeDebutEtude;
	private int anneeFinEtude;
	private String posteOccupe;
	private String pays;
	private String ville;
	
	
	 @JsonManagedReference
	    @OneToMany(mappedBy = "emetteur", cascade = CascadeType.ALL)
	private List<Message> messagesEnvoyes;
	
	 @JsonManagedReference
	    @OneToMany(mappedBy = "recepteur", cascade = CascadeType.ALL)
	private List<Message> messagesRecus;
	
	@JsonManagedReference
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Experience> experiences;
	
	@JsonManagedReference
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Formation> formations;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="utilisateur-competences", joinColumns = @JoinColumn(name="utilisateur_id"),
	inverseJoinColumns = @JoinColumn(name="competence_id"))
	private List<Competence> competences;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Publication> publications;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Commentaire> commentaires;
	
	@JsonManagedReference
    @JsonIgnore
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Partage> partages;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Notification> notifications;
	
	@ManyToMany
	@JsonIgnore
	@JsonManagedReference
	@JoinTable(name="suivi",  
	joinColumns = @JoinColumn(name = "suiveur_id"),
	inverseJoinColumns = @JoinColumn(name="suivi_id"))
	private List<Utilisateur> suivis = new ArrayList<>();
	
	@ManyToMany(mappedBy =  "suivis")
	@JsonManagedReference
	@JsonIgnore
	private List<Utilisateur> suiveurs = new ArrayList<>();
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
	private List<Like> likes;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonManagedReference
	@JoinTable(	name = "utilisateurs_roles", 
				joinColumns = @JoinColumn(name = "utilisateur_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();
	
	//constructors
	public Utilisateur(String email, String password) {
		this.email = email;
		this.password = password;		
	}
	
	
	
	
	public Utilisateur(String nom, String prenom, String username, String email, Date dateNaissance,
			String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.password = password;
	}

	

	


	public Utilisateur( String nom, String prenom, String email, Date dateNaissance, String password, String telephone,
			Boolean estEtudiant, String ecole, int anneeDebutEtude, int anneeFinEtude, String posteOccupe, String pays,
			String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.password = password;
		this.estEtudiant = estEtudiant;
		this.ecole = ecole;
		this.anneeDebutEtude = anneeDebutEtude;
		this.anneeFinEtude = anneeFinEtude;
		this.posteOccupe = posteOccupe;
		this.pays = pays;
		this.ville = ville;
	}




	public Boolean getEstEtudiant() {
		return estEtudiant;
	}




	public void setEstEtudiant(Boolean estEtudiant) {
		this.estEtudiant = estEtudiant;
	}




	public String getEcole() {
		return ecole;
	}




	public void setEcole(String ecole) {
		this.ecole = ecole;
	}




	public int getAnneeDebutEtude() {
		return anneeDebutEtude;
	}




	public void setAnneeDebutEtude(int anneeDebutEtude) {
		this.anneeDebutEtude = anneeDebutEtude;
	}




	public int getAnneeFinEtude() {
		return anneeFinEtude;
	}




	public void setAnneeFinEtude(int anneeFinEtude) {
		this.anneeFinEtude = anneeFinEtude;
	}




	public String getPosteOccupe() {
		return posteOccupe;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public void setPosteOccupe(String posteOccupe) {
		this.posteOccupe = posteOccupe;
	}




	public String getPays() {
		return pays;
	}




	public void setPays(String pays) {
		this.pays = pays;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVisibilte() {
		return visibilte;
	}
	public void setVisibilte(String visibilte) {
		this.visibilte = visibilte;
	}
	public String getPhotoProfil() {
		return photoProfil;
	}
	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}
	public String getTypeProfil() {
		return typeProfil;
	}
	public void setTypeProfil(String typeProfil) {
		this.typeProfil = typeProfil;
	}
	public String getPhotoCouverture() {
		return photoCouverture;
	}
	public void setPhotoCouverture(String photoCouverture) {
		this.photoCouverture = photoCouverture;
	}
	@JsonManagedReference(value="utilisateur-message")
	public List<Message> getMessagesEnvoyes() {
		return messagesEnvoyes;
	}
	public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
		this.messagesEnvoyes = messagesEnvoyes;
	}
	@JsonManagedReference(value="utilisateur-message")
	public List<Message> getMessagesRecus() {
		return messagesRecus;
	}
	public void setMessagesRecus(List<Message> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}
	@JsonManagedReference(value="utilisateur-experience")
	public List<Experience> getExperiences() {
		return experiences;
	}
	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	@JsonManagedReference(value="utilisateur-formation")
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	@JsonManagedReference(value="utilisateur-comptence")
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	
	@JsonManagedReference(value="utilisateur-publication")
	public List<Publication> getPublications() {
		return publications;
	}
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	@JsonManagedReference(value="utilisateur-commentaire")
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	@JsonManagedReference(value="utilisateur-partage")
	public List<Partage> getPartages() {
		return partages;
	}
	public void setPartages(List<Partage> partages) {
		this.partages = partages;
	}
	@JsonManagedReference(value="utilisateur-notification")
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	@JsonManagedReference(value="utilisateur-suivi")
	public List<Utilisateur> getSuivis() {
		return suivis;
	}
	
	public void setSuivis(List<Utilisateur> suivis) {
		this.suivis = suivis;
	}
	@JsonManagedReference(value="utilisateur-suiveur")
	public List<Utilisateur> getSuiveurs() {
		return suiveurs;
	}
	public void setSuiveurs(List<Utilisateur> suiveurs) {
		this.suiveurs = suiveurs;
	}
	@JsonManagedReference(value="utilisateur-like")
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username
				+ ", dateNaissance=" + dateNaissance + ", password=" + password + ", visibilte=" + visibilte
				+ ", photoProfil=" + photoProfil + ", typeProfil=" + typeProfil + ", photoCouverture=" + photoCouverture
				+ ", messagesEnvoyes=" + messagesEnvoyes + ", messagesRecus=" + messagesRecus + ", experiences="
				+ experiences + ", formations=" + formations + ", competences=" + competences + ", publications="
				+ publications + ", commentaires=" + commentaires + ", partages=" + partages + ", notifications="
				+ notifications + ", suivis=" + suivis + ", suiveurs=" + suiveurs + ", likes=" + likes + ", roles="
				+ roles + "]";
	}
	
	
}
