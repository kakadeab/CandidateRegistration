
package com.mobiliya.entity.registration;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mobiliya.entity.exam.Exam;
/**
 * 
 * @author Amol.Kakade
 * 
 */
@Entity
@Table(name = "CANDIDATE_REGISTRATION")
public class CandidateRegistration {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "SKILLS")
	private String skills;

	 @OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="CANDIDATE_EXAM", joinColumns={@JoinColumn(name="CANDIDATE_ID", referencedColumnName="ID")}
	    , inverseJoinColumns={@JoinColumn(name="EXAM_ID", referencedColumnName="ID")})
	private Set<Exam> exam;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Set<Exam> getExam() {
		return exam;
	}

	public void setExam(Set<Exam> exam) {
		this.exam = exam;
	}

}
