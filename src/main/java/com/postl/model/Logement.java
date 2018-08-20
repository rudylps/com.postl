package com.postl.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;

@CrossOrigin("*")
@Entity
@Table(name = "logements")
public class Logement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long logement_id;

	private String photo;
	
	private String numero_rue;
	private String type_rue;
	private String nom_rue;
	private String complement_adresse;
	@NotNull
	@Pattern (regexp = "^[0-9]{5}$")
	private String code_postal;
	@NotNull
	private String ville;
	
	@NotNull
	private double prix_nuit;
	@Size(max = 250)
	private String description;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "utilisateur_id", nullable = true)
//	@JsonBackReference
//	private Utilisateur utilisateur;

	public Long getLogement_id() {
		return logement_id;
	}

	public void setLogement_id(Long logement_id) {
		this.logement_id = logement_id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNumero_rue() {
		return numero_rue;
	}

	public void setNumero_rue(String numero_rue) {
		this.numero_rue = numero_rue;
	}

	public String getType_rue() {
		return type_rue;
	}

	public void setType_rue(String type_rue) {
		this.type_rue = type_rue;
	}

	public String getNom_rue() {
		return nom_rue;
	}

	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}

	public String getComplement_adresse() {
		return complement_adresse;
	}

	public void setComplement_adresse(String complement_adresse) {
		this.complement_adresse = complement_adresse;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getPrix_nuit() {
		return prix_nuit;
	}

	public void setPrix_nuit(double prix_nuit) {
		this.prix_nuit = prix_nuit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Utilisateur getUtilisateur() {
//		return utilisateur;
//	}
//
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}
	
}
