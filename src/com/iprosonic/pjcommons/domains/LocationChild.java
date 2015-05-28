package com.iprosonic.pjcommons.domains;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LocationChild entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "location_child", catalog = "petition")
public class LocationChild implements java.io.Serializable {

	// Fields

	private LocationChildId id;
	private Location locationByParentLocation;
	private Location locationByChildLocation;
	private String remarks;

	// Constructors

	/** default constructor */
	public LocationChild() {
	}

	/** minimal constructor */
	public LocationChild(LocationChildId id, Location locationByParentLocation,
			Location locationByChildLocation) {
		this.id = id;
		this.locationByParentLocation = locationByParentLocation;
		this.locationByChildLocation = locationByChildLocation;
	}

	/** full constructor */
	public LocationChild(LocationChildId id, Location locationByParentLocation,
			Location locationByChildLocation, String remarks) {
		this.id = id;
		this.locationByParentLocation = locationByParentLocation;
		this.locationByChildLocation = locationByChildLocation;
		this.remarks = remarks;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "parentLocation", column = @Column(name = "parent_location", nullable = false)),
			@AttributeOverride(name = "childLocation", column = @Column(name = "child_location", nullable = false)) })
	public LocationChildId getId() {
		return this.id;
	}

	public void setId(LocationChildId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_location", nullable = false, insertable = false, updatable = false)
	public Location getLocationByParentLocation() {
		return this.locationByParentLocation;
	}

	public void setLocationByParentLocation(Location locationByParentLocation) {
		this.locationByParentLocation = locationByParentLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_location", nullable = false, insertable = false, updatable = false)
	public Location getLocationByChildLocation() {
		return this.locationByChildLocation;
	}

	public void setLocationByChildLocation(Location locationByChildLocation) {
		this.locationByChildLocation = locationByChildLocation;
	}

	@Column(name = "remarks", length = 45)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}