package com.iprosonic.petiton.web.jsf;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.Petition;

@ManagedBean(name = "petitionDuplicateCheckComponent")
@ViewScoped
public class PetitionDuplicateCheckComponent {
	private PetionService	petitionService			= new PetionService();

	private List<Petition>	listDuplicatePetitons	= new ArrayList<Petition>();

	public List<Petition> getListDuplicatePetitons() {
		return listDuplicatePetitons;
	}

	public void setListDuplicatePetitons(List<Petition> listDuplicatePetitons) {
		this.listDuplicatePetitons = listDuplicatePetitons;
	}

	public void handleKeyEventMobileNo(AjaxBehaviorEvent event) {
		String value = (String) ((UIOutput) event.getSource()).getValue();
		listDuplicatePetitons = petitionService.getPetitionListByMobileNo(value);
		setListDuplicatePetitons(listDuplicatePetitons);
	}

	public void handleKeyEventPhoneNo(AjaxBehaviorEvent event) {
		String value = (String) ((UIOutput) event.getSource()).getValue();
		listDuplicatePetitons = petitionService.getPetitionListByPhoneNo(value);
		setListDuplicatePetitons(listDuplicatePetitons);
	}
}
