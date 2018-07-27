package com.postl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.postl.model.Utilisateur;
import com.postl.repository.IUtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private static IUtilisateurRepository utilisateurRepository;
	
	public static Iterable<Utilisateur> findAllUtilisateurs() throws Exception {
		return ((CrudRepository<Utilisateur,Long>) utilisateurRepository).findAll();
	}
	
	public static Optional<Utilisateur> findOneUtilisateur(Long utilisateurId) throws Exception {
		return ((CrudRepository<Utilisateur, Long>) utilisateurRepository).findById(utilisateurId);
	}

	public void deleteUtilisateur(Long utilisateurId) {
		((CrudRepository<Utilisateur, Long>) utilisateurRepository).deleteById(utilisateurId);
	}

	public static Utilisateur createUtilisateur(Utilisateur utilisateur) throws Exception {
		return ((CrudRepository<Utilisateur, Long>) utilisateurRepository).save(utilisateur);
	}

	public Utilisateur updateUtilisateur(Long utilisateurId, Utilisateur utilisateur) throws Exception {
		return ((CrudRepository<Utilisateur, Long>) utilisateurRepository).save(utilisateur);
	}

}
