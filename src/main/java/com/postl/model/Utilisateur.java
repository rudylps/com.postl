package com.postl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long utilisateur_id;
	@NotNull
	@Size(max = 7)
	@Column(unique = true)
	private String id_rh;
	@NotNull
	@Size(min = 6)
	private String mot_de_passe;
	@NotNull
	@Size(max = 20)
	private String nom;
	@NotNull
	@Size(max = 50)
	private String prenom;
	@NotNull
	@Size(max = 50)
	private String bureau;
	@NotNull
	@Size(max = 50)
	private String mail;
	@NotNull
	@Size(max = 12)
	private String telephone;

	public Long getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(Long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public String getId_rh() {
		return id_rh;
	}

	public void setId_rh(String id_rh) {
		this.id_rh = id_rh;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
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

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
