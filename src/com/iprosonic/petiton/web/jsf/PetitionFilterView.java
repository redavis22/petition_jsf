package com.iprosonic.petiton.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.Petition;

@ManagedBean(name = "PetitionFilterView")
@ViewScoped
public class PetitionFilterView implements Serializable {

	/**
	 * 
	 */
	private static final long			serialVersionUID	= 1L;

	private List<Petition>				petitions;
	private List<Petition>				filterPetitions;

	private static final PetionService	petionService		= new PetionService();

	@PostConstruct
	public void init() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String location = request.getSession().getAttribute("location").toString();
			petitions = petionService.getPetitionList(location);
			setPetitions(petitions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Petition> getPetitions() {
		return petitions;
	}

	public void setPetitions(List<Petition> petitions) {
		this.petitions = petitions;
	}

	public List<Petition> getFilterPetitions() {
		return filterPetitions;
	}

	public void setFilterPetitions(List<Petition> filterPetitions) {
		this.filterPetitions = filterPetitions;
	}
}
