package com.postl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.postl.model.Logement;
import com.postl.repository.ILogementRepository;

@Service
public class LogementService {
	
	@Autowired
	private static ILogementRepository logementRepository;
	
	public static Iterable<Logement> findAllLogements() throws Exception {
		return ((CrudRepository<Logement,Long>) logementRepository).findAll();
	}
	
	public static Optional<Logement> findOneLogement(Long logementId) throws Exception {
		return ((CrudRepository<Logement, Long>) logementRepository).findById(logementId);
	}

	public void deleteLogement(Long logement_id) {
		((CrudRepository<Logement, Long>) logementRepository).deleteById(logement_id);
	}

	public static Logement createLogement(Logement logement) throws Exception {
		return ((CrudRepository<Logement, Long>) logementRepository).save(logement);
	}

	public Logement updateLogement(Long logementId, Logement logement) throws Exception {
		return ((CrudRepository<Logement, Long>) logementRepository).save(logement);
	}

}
