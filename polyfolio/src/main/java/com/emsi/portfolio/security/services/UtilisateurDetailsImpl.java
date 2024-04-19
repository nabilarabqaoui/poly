package com.emsi.portfolio.security.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.emsi.portfolio.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class UtilisateurDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom ;
	private String prenom;
	private String email;
	private String telephone;
	private Date dateNaissance;
	private Boolean estEtudiant;
	private String ecole;
	private int anneeDebut;
	private int anneeFin;
	private String posteOccupe;
	private String pays;
	private String ville;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UtilisateurDetailsImpl(Long id, String nom, String prenom, String email, String telephone, String password, Date dateNaissance, String pays, String ville,
			Boolean estEtudiant, String ecole, int anneeDebut, int anneeFin, String posteOccupe, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.ville = ville;
		this.estEtudiant = estEtudiant;
		this.ecole = ecole;
		this.anneeDebut = anneeDebut;
		this.anneeFin = anneeFin;
		this.posteOccupe = posteOccupe;
		this.authorities = authorities;
	}
	
	 public static UtilisateurDetailsImpl build(Utilisateur user) {
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());

		    return new UtilisateurDetailsImpl(
		        user.getId(), 
		        user.getNom(),
		        user.getPrenom(),
		        user.getEmail(),
		        user.getTelephone(),
		        user.getPassword(),
		        user.getDateNaissance(),
		        user.getPays(),
		        user.getVille(),
		        user.getEstEtudiant(),
		        user.getEcole(),
		        user.getAnneeDebutEtude(),
		        user.getAnneeFinEtude(),
		        user.getPosteOccupe(),
		        authorities);
		  }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getEstEtudiant() {
		return estEtudiant;
	}

	public String getEcole() {
		return ecole;
	}

	public int getAnneeDebut() {
		return anneeDebut;
	}

	public int getAnneeFin() {
		return anneeFin;
	}

	public String getPosteOccupe() {
		return posteOccupe;
	}

	public String getPays() {
		return pays;
	}

	public String getVille() {
		return ville;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UtilisateurDetailsImpl user = (UtilisateurDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }
	

}
