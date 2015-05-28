package com.iprosonic.pjcommons.dropdown.web.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.iprosonic.master.location.service.LocationService;
import com.iprosonic.pjcommons.domains.Location;

@ManagedBean
@javax.faces.bean.SessionScoped
public class DropdownView implements Serializable {

	private static final long					serialVersionUID	= 1L;
	private Map<String, Map<String, String>>	data				= new HashMap<String, Map<String, String>>();
	private String								country;
	private String								city;
	private String								idProof;
	private String								gender;
	private String								location;
	private Map<String, String>					countries;
	private Map<String, String>					cities;
	private Map<String, String>					idProofs;
	private Map<String, String>					genders;
	private Map<String, String>					locations;
	private Map<String, String>					distict;
	LocationService								locationService		= new LocationService();

	@PostConstruct
	public void init() {

		// ID Proofs
		setIdProofs(new HashMap<String, String>());
		getIdProofs().put("Aadhar card", "Aadhar card");
		getIdProofs().put("Bank Account No", "Bank Account No");
		getIdProofs().put("Driving Licence", "Driving Licence");
		getIdProofs().put("Narega Job Card", "Narega Job Card");
		getIdProofs().put("Pan Card", "Pan Card");
		getIdProofs().put("Passport", "Passport");
		getIdProofs().put("Ration Card", "Ration Card");
		// distict

		setDistict(new HashMap<String, String>());

		getDistict().put("Bundi", "Bundi");
		getDistict().put("Dausa", "Dausa");
		getDistict().put("Churu", "Churu");
		getDistict().put("Tonk", "Tonk");
		getDistict().put("Barmer", "Barmer");
		getDistict().put("Chittaurgarh", "Chittaurgarh");

		// Genders
		setGenders(new HashMap<String, String>());
		getGenders().put("Male", "Male");
		getGenders().put("Female", "Female");

		// Locations
		setLocations(new HashMap<String, String>());

		List<Location> locationList = locationService.getAllLocationsList();

		for (Location location : locationList) {
			getLocations().put(location.getName(), location.getName());
		}

	
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void onCountryChange() {
		if (country != null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}

	public void displayLocation() {
		FacesMessage msg;
		if (city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public Map<String, String> getIdProofs() {
		return idProofs;
	}

	public void setIdProofs(Map<String, String> idProofs) {
		this.idProofs = idProofs;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Map<String, String> getGenders() {
		return genders;
	}

	public void setGenders(Map<String, String> genders) {
		this.genders = genders;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, String> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, String> locations) {
		this.locations = locations;
	}

	public Map<String, String> getDistict() {
		return distict;
	}

	public void setDistict(Map<String, String> distict) {
		this.distict = distict;
	}

}