package com.mobiliya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobiliya.dto.RegistrationDTO;
import com.mobiliya.service.RegistrationService;

/**
 * This controller class is used to register a candidate and get candidate details.
 * 
 * @author Amol.Kakade
 */

@RestController
@RequestMapping(value = "/api/candidate")
public class CandidateController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	private RegistrationService candidateRegistration;
	
	/**
	 * This method is used to register a new candidate and returns it's ID.
	 *  
	 * @param registrationDto request body
	 * @return Newly registered candidate ID.
	 */
	@PostMapping(value = {"/registration"}, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrationDTO> registerCandidate(@RequestBody RegistrationDTO registrationDto)
	{
		LOGGER.info("Candidate Registration :: {} ", registrationDto);
		//Call service method and return the response
		return new ResponseEntity<>(candidateRegistration.registerCandidate(registrationDto), HttpStatus.CREATED);
	}
	
	/**
	 * This method is used to fetch the candidate registration details by using it's ID.
	 * 
	 * @param id Candidate Id to fetch the candidate registration details
	 * @return returns candidate registration details in the JSON form.
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrationDTO> getCandidateDetailsById(@PathVariable Long id) {
		LOGGER.info("getCandidateDetailsById: , candidateId: {} ", id);
		//Call service method and return the response
		return new ResponseEntity<>(candidateRegistration.getCandidateDetailsById(id), HttpStatus.OK);
	}
}
