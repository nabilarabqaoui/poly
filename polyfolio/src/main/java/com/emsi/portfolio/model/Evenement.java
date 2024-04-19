package com.emsi.portfolio.model;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Evenement extends Publication{
	private String type;
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private int heureDebut;
	private int heureFin;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}
	public int getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}
	@Override
	public String toString() {
		return "Evenement [type=" + type + ", titre=" + titre + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + "]";
	}
	
	

}
