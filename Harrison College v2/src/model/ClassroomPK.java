package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CLASSROOMS database table.
 * 
 */
@Embeddable
public class ClassroomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROOM_NUMBER")
	private long roomNumber;

	@Column(name="BUILDING_NAME")
	private String buildingName;

	public ClassroomPK() {
	}
	public long getRoomNumber() {
		return this.roomNumber;
	}
	public void setRoomNumber(long roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBuildingName() {
		return this.buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClassroomPK)) {
			return false;
		}
		ClassroomPK castOther = (ClassroomPK)other;
		return 
			(this.roomNumber == castOther.roomNumber)
			&& this.buildingName.equals(castOther.buildingName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.roomNumber ^ (this.roomNumber >>> 32)));
		hash = hash * prime + this.buildingName.hashCode();
		
		return hash;
	}
}