package com.mobiliya.service;

import com.mobiliya.dto.RegistrationDTO;

/**
 * 
 * @author Amol.Kakade
 *
 */
public interface Registration {

	/**
	 * This method is used to perform the business logic for the Candidate registration.
	 * @param registrationDto {@link RegistrationDTO} 
	 * @return Returns the response registration DTO
	 */
	RegistrationDTO registerCandidate(RegistrationDTO registrationDto);

	/**
	 * This method is used to get the candidate details with list of exams by using ID
	 * @param id ID of the candidate
	 * @return Candidate details with list of exams.
	 */
	RegistrationDTO getCandidateDetailsById(Long id);
}
