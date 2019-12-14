package com.mobiliya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobiliya.entity.registration.CandidateRegistration;


/**
 * 
 * @author Amol.Kakade
 *
 */
@Repository
public interface CandidateRepository extends JpaRepository<CandidateRegistration, Long> {
	
	
}
