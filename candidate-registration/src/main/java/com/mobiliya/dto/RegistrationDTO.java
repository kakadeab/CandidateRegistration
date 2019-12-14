
package com.mobiliya.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * @author Amol.Kakade
 * 
 * RegistrationDTO class is used to map the request and to send the response.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO implements Serializable {

	private static final long serialVersionUID = 9223259172452864633L;

	private Long id;

	private String name;

	private String qualification;

	private String experience;

	private String date;

	private String skills;

	private List<ExamDTO> exam = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<ExamDTO> getExam() {
		return exam;
	}

	public void setExam(List<ExamDTO> exam) {
		this.exam = exam;
	}

}
