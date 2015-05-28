package com.iprosonic.pjcommons.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LocationChildId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class LocationChildId implements java.io.Serializable {

	// Fields

	private Integer parentLocation;
	private Integer childLocation;

	// Constructors

	/** default constructor */
	public LocationChildId() {
	}

	/** full constructor */
	public LocationChildId(Integer parentLocation, Integer childLocation) {
		this.parentLocation = parentLocation;
		this.childLocation = childLocation;
	}

	// Property accessors

	@Column(name = "parent_location", nullable = false)
	public Integer getParentLocation() {
		return this.parentLocation;
	}

	public void setParentLocation(Integer parentLocation) {
		this.parentLocation = parentLocation;
	}

	@Column(name = "child_location", nullable = false)
	public Integer getChildLocation() {
		return this.childLocation;
	}

	public void setChildLocation(Integer childLocation) {
		this.childLocation = childLocation;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LocationChildId))
			return false;
		LocationChildId castOther = (LocationChildId) other;

		return ((this.getParentLocation() == castOther.getParentLocation()) || (this
				.getParentLocation() != null
				&& castOther.getParentLocation() != null && this
				.getParentLocation().equals(castOther.getParentLocation())))
				&& ((this.getChildLocation() == castOther.getChildLocation()) || (this
						.getChildLocation() != null
						&& castOther.getChildLocation() != null && this
						.getChildLocation()
						.equals(castOther.getChildLocation())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getParentLocation() == null ? 0 : this.getParentLocation()
						.hashCode());
		result = 37
				* result
				+ (getChildLocation() == null ? 0 : this.getChildLocation()
						.hashCode());
		return result;
	}

}