package com.mobiliya.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mobiliya.controller.CandidateController;
import com.mobiliya.dto.ExamDTO;
import com.mobiliya.dto.RegistrationDTO;
import com.mobiliya.entity.exam.Exam;
import com.mobiliya.entity.registration.CandidateRegistration;
import com.mobiliya.repository.CandidateRepository;
import com.mobiliya.utils.DateUtil;

/**
 * 
 * @author Amol.Kakade
 *
 *         This service class is used to perform business logic related to the
 *         candidate.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public RegistrationDTO registerCandidate(RegistrationDTO registrationDto) {

		// Get the populated CandidateRegistration entity and call save method of the
		// CandidateRepository
		CandidateRegistration savedEntity = candidateRepository.save(populateEntity(registrationDto));

		// Set the newly registered candidate Id in the response DTO and return the
		// same.
		RegistrationDTO responseDto = new RegistrationDTO();
		responseDto.setId(savedEntity.getId());
		return responseDto;
	}

	/**
	 * This method used to get the CandidateRegistration entity from the
	 * RegistrationDTO.
	 * 
	 * @param source request parameters
	 * @return Populated entity from the request parameter
	 */
	private CandidateRegistration populateEntity(RegistrationDTO source) {
		CandidateRegistration target = new CandidateRegistration();

		target.setDate(new Date());
		target.setExperience(source.getExperience());
		target.setName(source.getName());
		target.setQualification(source.getQualification()); 
		target.setSkills(source.getSkills()); 

		Set<Exam> examSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(source.getExam())) {
			
			for (ExamDTO examDto : source.getExam()) {
				Exam exam = new Exam();
				exam.setDate(DateUtil.parseDate(examDto.getDate()));
				exam.setPosition(examDto.getPosition());

				examSet.add(exam);
			}}
		
		target.setExam(examSet);

		return target;
	}

	@Override
	public RegistrationDTO getCandidateDetailsById(Long id) {

		// Call the findById method of the CandidateRepository and get the optional of
		// the CandidateRegistration.
		Optional<CandidateRegistration> candidateOptional = candidateRepository.findById(id);

		//Check whether the CandidateRegistration is available for the provided id.
		if (!candidateOptional.isPresent()) {
			LOGGER.info("Candidate not found for the Id : {}, returning empty response ", id);
			return new RegistrationDTO();
		}
		
		//populateResponseDTO method will create the response and returns it.
		return populateResponseDTO(candidateOptional.get());

	}

	private RegistrationDTO populateResponseDTO(CandidateRegistration source) {
		RegistrationDTO target = new RegistrationDTO();

		if (source.getDate() != null) {
			target.setDate(source.getDate().toString());
		}

		target.setExperience(source.getExperience());
		target.setId(source.getId());
		target.setName(source.getName());
		target.setQualification(source.getQualification());
		target.setSkills(source.getSkills());

		List<ExamDTO> examDtoList = new ArrayList<>();

		for (Exam exam : source.getExam()) {
			ExamDTO examDto = new ExamDTO();

			if (exam.getDate() != null) {
				examDto.setDate(exam.getDate().toString());
			}
			examDto.setId(exam.getId());
			examDto.setPosition(exam.getPosition());

			examDtoList.add(examDto);

		}
		target.setExam(examDtoList);
		return target;
	}

}
