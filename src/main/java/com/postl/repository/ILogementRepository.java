package com.postl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.postl.model.Logement;

@Repository
public interface ILogementRepository extends JpaRepository<Logement, Long> {

	@Query("select l FROM Logement l WHERE l.ville LIKE :a AND l.code_postal LIKE :b ")
		public List<Logement> chercher(@Param("a") String ville,
			   @Param("b") String cp);

}
