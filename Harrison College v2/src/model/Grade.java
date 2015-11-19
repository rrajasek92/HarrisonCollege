package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRADES database table.
 * 
 */
@Entity
@Table(name="GRADES")
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRADES_GRADEID_GENERATOR", sequenceName="GRADES_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADES_GRADEID_GENERATOR")
	@Column(name="GRADE_ID")
	private long gradeId;

	private BigDecimal crn;

	@Column(name="LETTER_GRADE")
	private String letterGrade;

	@Column(name="STUDENT_ID")
	private BigDecimal studentId;

	public Grade() {
	}

	public long getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

	public BigDecimal getCrn() {
		return this.crn;
	}

	public void setCrn(BigDecimal crn) {
		this.crn = crn;
	}

	public String getLetterGrade() {
		return this.letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public BigDecimal getStudentId() {
		return this.studentId;
	}

	public void setStudentId(BigDecimal studentId) {
		this.studentId = studentId;
	}

}