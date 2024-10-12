package com.reto.seek.demo.infraestructure.repository;

import com.reto.seek.demo.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByActiveTrue();

    Optional<Candidate> findByIdAndActiveTrue(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Candidate p SET p.active = false WHERE p.id = :id")
    void deactivateCandidate(Long id);

}
