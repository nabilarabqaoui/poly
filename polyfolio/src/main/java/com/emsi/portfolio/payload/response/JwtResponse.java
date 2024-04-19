package com.emsi.portfolio.payload.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
      private String token;
  private String type = "Bearer";
  private Long id;
  //private String username;
  private String email;
  private List<String> roles;
private String nom;
private String prenom;
private String telephone;
private Date dateNaissance;
private String pays;
private String ville;
private Boolean estEtudiant;
private String ecole;
private int anneeDebut;
private int anneeFin;
private String posteOccupe;


  public JwtResponse(String accessToken, Long id,String nom, String prenom, String email, String telephone, Date dateNaissance, String pays, String ville, Boolean estEtudiant, String ecole, int anneeDebut, int anneeFin, String posteOccupe, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.nom = nom;
    this.prenom  = prenom;
    this.email = email;
    this.telephone = telephone;
    this.dateNaissance = dateNaissance;
    this.pays = pays;
    this.ville = ville;
    this.estEtudiant = estEtudiant; 
    this.ecole = ecole;
    this.anneeDebut = anneeDebut;
    this.anneeFin = anneeFin;
    this.posteOccupe = posteOccupe;
    this.roles = roles;
   
  }

    /*public JwtResponse(String jwt, Long id, String username, List<String> roles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
