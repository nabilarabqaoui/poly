package com.emsi.portfolio.payload.request;

import java.util.Date;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
    @NotBlank

private String nom;
@NotBlank
private String prenom;
@NotBlank
private String telephone;
 @NotBlank
 @Size(max = 50)
 @Email
 private String email;
 
 
 private Boolean estEtudiant;
 private String ecole;
 private int anneeDebut;
 private int anneeFin;
 private String posteOccupe;
 private String pays;
 private String ville;
 private Date dateNaissance;

 private Set<String> role;

 @NotBlank
 @Size(min = 6, max = 40)
 private String password;

/* public String getUsername() {
   return username;
 }

 public void setUsername(String username) {
   this.username = username;
 }*/

 public String getEmail() {
   return email;
 }

 public void setEmail(String email) {
   this.email = email;
 }

 public String getPassword() {
   return password;
 }

 public void setPassword(String password) {
   this.password = password;
 }

 public Date getDateNaissance() {
	 return dateNaissance;
 }
 
 public void setDateNaissance(Date dateNaissance) {
	 this.dateNaissance = dateNaissance;
 }
 
 public Set<String> getRole() {
   return this.role;
 }

 public void setRole(Set<String> role) {
   this.role = role;
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

   public String getTelephone() {
       return telephone;
   }

   public void setTelephone(String telephone) {
       this.telephone = telephone;
   }

public Boolean getEstEtudiant() {
	return estEtudiant;
}

public void setIsEtudiant(Boolean estEtudiant) {
	this.estEtudiant = estEtudiant;
}

public String getEcole() {
	return ecole;
}

public void setEcole(String ecole) {
	this.ecole = ecole;
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

public String getPosteOccupe() {
	return posteOccupe;
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
   
   


}
