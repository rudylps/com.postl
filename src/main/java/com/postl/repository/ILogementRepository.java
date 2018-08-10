package com.postl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.postl.model.Logement;

@Repository
public interface ILogementRepository extends JpaRepository<Logement, Long> {

	@Query("SELECT l FROM Logement l WHERE l.code_postal LIKE :x")
	public List<Logement> chercher(@Param("x") String cp);
	
	@Query("SELECT l FROM Logement l WHERE l.ville LIKE :y")
	public List<Logement> chercherParVille(@Param("y") String ville);
	
	@Query("SELECT l FROM Logement l WHERE l.code_postal LIKE :x AND l.ville LIKE :y")
	public List<Logement> chercherParCriteres(@Param("y") String ville, @Param("x") String cp);
	
	@Query("select l from Logement l where l.ville like :a AND l.code_postal like :b ")
	public List<Logement> chercher(@Param("a") String ville,
			   @Param("b") String cp);

}
