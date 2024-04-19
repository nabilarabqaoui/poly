package com.emsi.portfolio.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Experience implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String intitule;
private String typeEmploi;
private String nomEntreprise;
private String lieu; 
private String typeLieu;
private Boolean estEnCours;
private String moisDebut;
private String moisFin;
private int anneeDebut;
private int anneeFin;
private String secteur;
private String description;
private String titreProfil;

@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
@OnDelete(action= OnDeleteAction.CASCADE)
@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
@JsonBackReference
private Utilisateur utilisateur;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIntitule() {
	return intitule;
}

public void setIntitule(String intitule) {
	this.intitule = intitule;
}

public String getTypeEmploi() {
	return typeEmploi;
}

public void setTypeEmploi(String typeEmploi) {
	this.typeEmploi = typeEmploi;
}

public String getNomEntreprise() {
	return nomEntreprise;
}

public void setNomEntreprise(String nomEntreprise) {
	this.nomEntreprise = nomEntreprise;
}

public String getLieu() {
	return lieu;
}

public void setLieu(String lieu) {
	this.lieu = lieu;
}

public String getTypeLieu() {
	return typeLieu;
}

public void setTypeLieu(String typeLieu) {
	this.typeLieu = typeLieu;
}

public Boolean getEstEnCours() {
	return estEnCours;
}

public void setEstEnCours(Boolean estEnCours) {
	this.estEnCours = estEnCours;
}

public String getMoisDebut() {
	return moisDebut;
}

public void setMoisDebut(String moisDebut) {
	this.moisDebut = moisDebut;
}

public String getMoisFin() {
	return moisFin;
}

public void setMoisFin(String moisFin) {
	this.moisFin = moisFin;
}

public int getAnneeDebut() {
	return anneeDebut;
}

public void setAnneeDebut(int anneeDebut) {
	this.anneeDebut = anneeDebut;
}

public int getAnneeFin() {
	return anneeFin;
}

public void setAnneeFin(int anneeFin) {
	this.anneeFin = anneeFin;
}

public String getSecteur() {
	return secteur;
}

public void setSecteur(String secteur) {
	this.secteur = secteur;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getTitreProfil() {
	return titreProfil;
}

public void setTitreProfil(String titreProfil) {
	this.titreProfil = titreProfil;
}
@JsonBackReference(value="experience-utilisateur")
public Utilisateur getUtilisateur() {
	return utilisateur;
}

public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}

@Override
public String toString() {
	return "Experience [id=" + id + ", intitule=" + intitule + ", typeEmploi=" + typeEmploi + ", nomEntreprise="
			+ nomEntreprise + ", lieu=" + lieu + ", typeLieu=" + typeLieu + ", estEnCours=" + estEnCours
			+ ", moisDebut=" + moisDebut + ", moisFin=" + moisFin + ", anneeDebut=" + anneeDebut + ", anneeFin="
			+ anneeFin + ", secteur=" + secteur + ", description=" + description + ", titreProfil=" + titreProfil
			+ ", utilisateur=" + utilisateur + "]";
}


}
