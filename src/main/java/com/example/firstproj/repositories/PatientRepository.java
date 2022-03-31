package com.example.firstproj.repositories;

import com.example.firstproj.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

     List<Patient> findByMalade(boolean v);
     Page<Patient> findByMalade(boolean v, Pageable p);
     List<Patient> findByNomAndScoreLessThan(String nom,int score);

     @Query("select p from Patient p where p.malade =:x")
     List<Patient> ChercherPatientMalade(@Param("x") boolean v);


}
