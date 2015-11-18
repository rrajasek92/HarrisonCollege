package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CLASSROOMS database table.
 * 
 */
@Entity
@Table(name="CLASSROOMS")
@NamedQuery(name="Classroom.findAll", query="SELECT c FROM Classroom c")
public class Classroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClassroomPK id;

	@Column(name="MAX_CAPACITY")
	private BigDecimal maxCapacity;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="classroom")
	private List<Hclass> hclasses;

	public Classroom() {
	}

	public ClassroomPK getId() {
		return this.id;
	}

	public void setId(ClassroomPK id) {
		this.id = id;
	}

	public BigDecimal getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(BigDecimal maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setClassroom(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setClassroom(null);

		return hclass;
	}

}