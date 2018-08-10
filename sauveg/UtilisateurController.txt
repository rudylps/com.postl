package com.postl.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.postl.model.Utilisateur;
import com.postl.repository.IUtilisateurRepository;

@RestController
@RequestMapping("")
public class UtilisateurController {

	@Autowired
	IUtilisateurRepository iUtilisateurRepository;

	@GetMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return iUtilisateurRepository.findAll();
	}

	@GetMapping("/utilisateur/{utilisateur_id}")
	public Optional<Utilisateur> findOneUtilisateur(@PathVariable(value = "utilisateur_id") Long utilisateur_id) {
		return iUtilisateurRepository.findById(utilisateur_id);
	}

	@PostMapping("/createUtilisateur")
	public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
		return iUtilisateurRepository.save(utilisateur);
	}

	@DeleteMapping("/utilisateur/{utilisateur_id}")
	public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "utilisateur_id") Long utilisateur_id) {
		iUtilisateurRepository.deleteById(utilisateur_id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/utilisateur/{utilisateur_id}")
	public Utilisateur updateUtilisateur(@PathVariable Long utilisateur_id,
			@Valid @RequestBody Utilisateur utilisateurDetails) {
		return iUtilisateurRepository.findById(utilisateur_id).map(utilisateur -> {
			utilisateur.setId_rh(utilisateurDetails.getId_rh());
			utilisateur.setMot_de_passe(utilisateurDetails.getMot_de_passe());
			utilisateur.setNom(utilisateurDetails.getNom());
			utilisateur.setPrenom(utilisateurDetails.getPrenom());
			utilisateur.setBureau(utilisateurDetails.getBureau());
			utilisateur.setMail(utilisateurDetails.getMail());
			utilisateur.setTelephone(utilisateurDetails.getTelephone());
//			utilisateur.setLogements(utilisateurDetails.getLogements());
			return iUtilisateurRepository.save(utilisateur);
		}).orElseThrow(() -> new ResourceAccessException(utilisateur_id + " ??"));
	}

}
