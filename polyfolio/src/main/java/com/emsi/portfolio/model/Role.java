package com.emsi.portfolio.model;

import java.io.Serializable;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Role implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
@Column(length = 20)
private ERole name;

public Role() {
	
}

public Role(ERole name) {
	this.name = name;
}

@Override
public String toString() {
	return "Role [id=" + id + ", name=" + name + "]";
}

//getters and setters


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public ERole getName() {
	return name;
}

public void setName(ERole name) {
	this.name = name;
}




}
