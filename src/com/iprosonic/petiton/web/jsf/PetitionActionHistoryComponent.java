package com.iprosonic.petiton.web.jsf;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.PetitionAction;

@ManagedBean
public class PetitionActionHistoryComponent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2797691659514110154L;
	private List<PetitionAction> petitionActionList;
	private static final PetionService petionService = new PetionService();

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		setPetitionActionList(petionService.getPetitionActionList(Integer
				.parseInt(request.getSession().getAttribute("id").toString())));

	}

	public void onTabChange(TabChangeEvent event) {
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: "
				+ event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onTabClose(TabCloseEvent event) {
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: "
				+ event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<PetitionAction> getPetitionActionList() {
		return petitionActionList;
	}

	public void setPetitionActionList(List<PetitionAction> petitionActionList) {
		this.petitionActionList = petitionActionList;
	}

}
