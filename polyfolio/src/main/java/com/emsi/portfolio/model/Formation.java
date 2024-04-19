package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Formation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ecole;
	private String diplome;
	private String domaineEtude;
	private String moisDebut;
	private int anneeDebut;
	private String moisFin;
	private int anneeFin;
	private String resultatObtenu;
	private String description;
	private String activiteAssocie;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @OnDelete(action= OnDeleteAction.CASCADE)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;
	 
	@JsonManagedReference
	@OneToMany(mappedBy="formation", cascade=CascadeType.ALL)
	private List<Media> medias;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getDomaineEtude() {
		return domaineEtude;
	}
	public void setDomaineEtude(String domaineEtude) {
		this.domaineEtude = domaineEtude;
	}
	public String getMoisDebut() {
		return moisDebut;
	}
	public void setMoisDebut(String moisDebut) {
		this.moisDebut = moisDebut;
	}
	public int getAnneeDebut() {
		return anneeDebut;
	}
	public void setAnneeDebut(int anneeDebut) {
		this.anneeDebut = anneeDebut;
	}
	public String getMoisFin() {
		return moisFin;
	}
	public void setMoisFin(String moisFin) {
		this.moisFin = moisFin;
	}
	public int getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(int anneeFin) {
		this.anneeFin = anneeFin;
	}
	public String getResultatObtenu() {
		return resultatObtenu;
	}
	public void setResultatObtenu(String resultatObtenu) {
		this.resultatObtenu = resultatObtenu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActiviteAssocie() {
		return activiteAssocie;
	}
	public void setActiviteAssocie(String activiteAssocie) {
		this.activiteAssocie = activiteAssocie;
	}
	@JsonBackReference(value="formation-utilisateur")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@JsonManagedReference(value="formation-media")
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	@Override
	public String toString() {
		return "Formation [id=" + id + ", ecole=" + ecole + ", diplome=" + diplome + ", domaineEtude=" + domaineEtude
				+ ", moisDebut=" + moisDebut + ", anneeDebut=" + anneeDebut + ", moisFin=" + moisFin + ", anneeFin="
				+ anneeFin + ", resultatObtenu=" + resultatObtenu + ", description=" + description
				+ ", activiteAssocie=" + activiteAssocie + ", utilisateur=" + utilisateur + ", medias=" + medias + "]";
	}
	
	
	

}
