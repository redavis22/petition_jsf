package com.iprosonic.pjcommons.domains;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "location", catalog = "petition")
public class Location implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String address;
	private Set<LocationChild> locationChildsForParentLocation = new HashSet<LocationChild>(
			0);
	private Set<LocationChild> locationChildsForChildLocation = new HashSet<LocationChild>(
			0);

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** minimal constructor */
	public Location(String customer, String name, String description) {
		this.name = name;
	}

	/** full constructor */
	public Location(String customer, String name, String description,
			String address, String counry, String zip,
			Set<LocationChild> locationChildsForParentLocation,
			Set<LocationChild> locationChildsForChildLocation) {
		this.name = name;
		this.address = address;
		this.locationChildsForParentLocation = locationChildsForParentLocation;
		this.locationChildsForChildLocation = locationChildsForChildLocation;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locationByParentLocation")
	public Set<LocationChild> getLocationChildsForParentLocation() {
		return this.locationChildsForParentLocation;
	}

	public void setLocationChildsForParentLocation(
			Set<LocationChild> locationChildsForParentLocation) {
		this.locationChildsForParentLocation = locationChildsForParentLocation;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locationByChildLocation")
	public Set<LocationChild> getLocationChildsForChildLocation() {
		return this.locationChildsForChildLocation;
	}

	public void setLocationChildsForChildLocation(
			Set<LocationChild> locationChildsForChildLocation) {
		this.locationChildsForChildLocation = locationChildsForChildLocation;
	}

}