package com.iprosonic.petiton.report;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.PetitionStatus;

@ManagedBean(name = "petitionStatusReportComponent")
@SessionScoped
public class PetitionStatusReportComponent {

	private static final PetionService petionService = new PetionService();
	private List<PetitionStatus> petitionStatusList = new ArrayList<PetitionStatus>();

	@PostConstruct
	public String petitionStatusReport() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String location = request.getSession().getAttribute("location").toString();
		setPetitionStatusList(petionService.getPetitionStatusReport(location));
		return "/jsf/report/petitonStatusReport.xhtml";
	}

	public List<PetitionStatus> getPetitionStatusList() {
		return petitionStatusList;
	}

	public void setPetitionStatusList(List<PetitionStatus> petitionStatusList) {
		this.petitionStatusList = petitionStatusList;
	}
}
