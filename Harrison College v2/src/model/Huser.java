package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HUSERS database table.
 * 
 */
@Entity
@Table(name="HUSERS")
@NamedQuery(name="Huser.findAll", query="SELECT h FROM Huser h")
public class Huser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HUSERS_USERID_GENERATOR", sequenceName="HUSERS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HUSERS_USERID_GENERATOR")
	@Column(name="USER_ID")
	private long userId;

	@Column(name="DEPARTMENT_ID")
	private BigDecimal departmentId;

	private String email;

	@Column(name="ENTRY_YEAR")
	private String entryYear;

	@Column(name="FULL_NAME")
	private String fullName;

	private String major;

	private String password;

	@Column(name="\"POSITION\"")
	private String position;

	//bi-directional many-to-one association to ClassEnrollment
	@OneToMany(mappedBy="huser")
	private List<ClassEnrollment> classEnrollments;

	public Huser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntryYear() {
		return this.entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<ClassEnrollment> getClassEnrollments() {
		return this.classEnrollments;
	}

	public void setClassEnrollments(List<ClassEnrollment> classEnrollments) {
		this.classEnrollments = classEnrollments;
	}

	public ClassEnrollment addClassEnrollment(ClassEnrollment classEnrollment) {
		getClassEnrollments().add(classEnrollment);
		classEnrollment.setHuser(this);

		return classEnrollment;
	}

	public ClassEnrollment removeClassEnrollment(ClassEnrollment classEnrollment) {
		getClassEnrollments().remove(classEnrollment);
		classEnrollment.setHuser(null);

		return classEnrollment;
	}

}