package com.emsi.portfolio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Competence implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO) 
private Long id;
private String libelle;



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}



@Override
public String toString() {
	return "Competence [id=" + id + ", libelle=" + libelle  + "]";
}



}
