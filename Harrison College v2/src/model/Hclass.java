package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HCLASSES database table.
 * 
 */
@Entity
@Table(name="HCLASSES")
@NamedQuery(name="Hclass.findAll", query="SELECT h FROM Hclass h")
public class Hclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCLASSES_CRN_GENERATOR", sequenceName="CLASSES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCLASSES_CRN_GENERATOR")
	private long crn;

	@Column(name="INSTRUCTOR_ID")
	private String instructorId;

	private String semester;

	//bi-directional many-to-one association to ClassEnrollment
	@OneToMany(mappedBy="hclass")
	private List<ClassEnrollment> classEnrollments;

	//bi-directional many-to-one association to Classroom
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="BUILDING_NAME", referencedColumnName="BUILDING_NAME"),
		@JoinColumn(name="ROOM_NUMBER", referencedColumnName="ROOM_NUMBER")
		})
	private Classroom classroom;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Cours cours;

	public Hclass() {
	}

	public long getCrn() {
		return this.crn;
	}

	public void setCrn(long crn) {
		this.crn = crn;
	}

	public String getInstructorId() {
		return this.instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<ClassEnrollment> getClassEnrollments() {
		return this.classEnrollments;
	}

	public void setClassEnrollments(List<ClassEnrollment> classEnrollments) {
		this.classEnrollments = classEnrollments;
	}

	public ClassEnrollment addClassEnrollment(ClassEnrollment classEnrollment) {
		getClassEnrollments().add(classEnrollment);
		classEnrollment.setHclass(this);

		return classEnrollment;
	}

	public ClassEnrollment removeClassEnrollment(ClassEnrollment classEnrollment) {
		getClassEnrollments().remove(classEnrollment);
		classEnrollment.setHclass(null);

		return classEnrollment;
	}

	public Classroom getClassroom() {
		return this.classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}