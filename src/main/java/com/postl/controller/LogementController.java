package com.postl.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.postl.model.Logement;
import com.postl.repository.ILogementRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("")
public class LogementController {

	@Autowired
	ILogementRepository iLogementRepository;

	@GetMapping("/logements")
	public List<Logement> getAllLogements() {
		return iLogementRepository.findAll();
	}

	@GetMapping("/logement/{logement_id}")
	public Optional<Logement> findOneLogement(@PathVariable(value = "logement_id") Long logement_id) {
		return iLogementRepository.findById(logement_id);
	}
	
	@GetMapping("/chercherLogement")
	public List<Logement> chercherLogement(
			@RequestParam(name="ville", defaultValue="") String ville,
			@RequestParam(name="cp", defaultValue="") String cp
			) {
		return iLogementRepository.chercher("%" + ville + "%", "%" + cp + "%");
	}

	@PutMapping("/logement/{logement_id}")
	public Logement updateLogement(@PathVariable Long logement_id,
			@Valid @RequestBody Logement logementDetails) {
		
		return iLogementRepository.findById(logement_id).map(logement -> {
			
			logement.setPhoto(logementDetails.getPhoto());
			logement.setNumero_rue(logementDetails.getNumero_rue());
			logement.setType_rue(logementDetails.getType_rue());
			logement.setNom_rue(logementDetails.getNom_rue());
			logement.setComplement_adresse(logementDetails.getComplement_adresse());
			logement.setCode_postal(logementDetails.getCode_postal());
			logement.setVille(logementDetails.getVille());
			logement.setPrix_nuit(logementDetails.getPrix_nuit());
			logement.setDescription(logementDetails.getDescription());
			return iLogementRepository.save(logement);
			
		}).orElseThrow(() -> new ResourceAccessException(logement_id + " ??"));
	}

	@PostMapping("/createLogement")
	public Logement createLogement(@Valid @RequestBody Logement logement) {
		return iLogementRepository.save(logement);
	}

	@DeleteMapping("/logement/{logement_id}")
	public ResponseEntity<?> deleteLogement(@PathVariable(value = "logement_id") Long logement_id) {
		iLogementRepository.deleteById(logement_id);
		return ResponseEntity.ok().build();
	}

}
