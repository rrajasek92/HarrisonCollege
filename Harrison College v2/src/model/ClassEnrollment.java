package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CLASS_ENROLLMENT database table.
 * 
 */
@Entity
@Table(name="CLASS_ENROLLMENT",schema="TESTUSERDB")
@NamedQuery(name="ClassEnrollment.findAll", query="SELECT c FROM ClassEnrollment c")
public class ClassEnrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASS_ENROLLMENT_ENROLLMENTID_GENERATOR", sequenceName="CLASS_ENROLLMENT_SEQ1",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASS_ENROLLMENT_ENROLLMENTID_GENERATOR")
	@Column(name="ENROLLMENT_ID")
	private long enrollmentId;

	//bi-directional many-to-one association to Hclass
	@ManyToOne
	@JoinColumn(name="CRN")
	private Hclass hclass;

	//bi-directional many-to-one association to Huser
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Huser huser;

	public ClassEnrollment() {
	}

	public long getEnrollmentId() {
		return this.enrollmentId;
	}

	public void setEnrollmentId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Hclass getHclass() {
		return this.hclass;
	}

	public void setHclass(Hclass hclass) {
		this.hclass = hclass;
	}

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

}