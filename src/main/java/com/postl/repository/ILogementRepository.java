package com.postl.repository;

import com.postl.model.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogementRepository extends JpaRepository<Logement, Long> {

}
