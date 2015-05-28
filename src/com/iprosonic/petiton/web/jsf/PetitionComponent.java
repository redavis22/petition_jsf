package com.iprosonic.petiton.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.Petition;
import com.iprosonic.pjcommons.domains.PetitionAction;
import com.iprosonic.pjcommons.utils.SequenceNoUtil;

@ManagedBean(name = "petitionComponent")
@SessionScoped
public class PetitionComponent implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Petition			petition			= new Petition();
	private PetitionAction		petitionAction		= new PetitionAction();
	private PetionService		petitionService		= new PetionService();
	private List<Petition>		petitionList;
	private boolean				isFileUploadVisble	= false;

	@PostConstruct
	public String createPetition() {
		petition = new Petition();
		setFileUploadVisble(false);
		return "/jsf/petiton/createPetiton.xhtml";

	}

	@PostConstruct
	public String searchPetition() {
		petition = new Petition();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String location = request.getSession().getAttribute("location").toString();
		petitionList = getPetitionService().getPetitionList(location);
		return "/jsf/petiton/listPetitons.xhtml";

	}

	public String editPetition(Petition petition) {
		Integer id = petition.getPetitionId();
		petition = getPetitionService().editPetition(id);
		petitionAction = getPetitionService().editAction(id);
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().setAttribute("id", petition.getPetitionId());
		petitionAction = new PetitionAction();
		setPetition(petition);
		return "/jsf/petiton/editPetiton.xhtml";
	}

	public void savePetition(Petition petition, PetitionAction petitionAction) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String id = SequenceNoUtil.getLatestNoByCode("PETITION");
		String petionActionId = SequenceNoUtil.getLatestNoByCode("PETITION_ACTION");
		HttpSession httpSession = req.getSession();
		petition.setPetitionDate(req.getParameter("form2:button_input"));
		petition.setPetitionId(Integer.parseInt(id));		
		petitionAction.setActionTakenBy(httpSession.getAttribute("location").toString());
		petitionAction.setPetitionActionId(Integer.parseInt(petionActionId));
		getPetitionService().savePetiton(petition, petitionAction);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Petition No : "+ id +" successfully saved"));
		setFileUploadVisble(true);
		petition = new Petition();
		req.getSession().setAttribute("id", Integer.parseInt(id));
	}

	public void updatePetition(Petition petition, PetitionAction petitionAction) {
		String petionActionId = SequenceNoUtil.getLatestNoByCode("PETITION_ACTION");
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession httpSession = req.getSession();
		petitionAction.setPetitionActionId(Integer.parseInt(petionActionId));
		petitionAction.setActionTakenBy(httpSession.getAttribute("name").toString());
		getPetitionService().updatePetition(petition, petitionAction);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MESSAGE", "Petition : "+petition.getPetitionId()+" successfully updated"));
	}

	public void closePetition(Petition petition) {
		getPetitionService().closePetition(petition.getPetitionId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Petition successfully close"));
	}

	public void rejectPetition(Petition petition) {

		getPetitionService().rejectPetition(petition.getPetitionId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Petition successfully reject"));
	}

	public void resetPetition(Petition petition) {

		petition = new Petition();
	}

	public void handleKeyEvent() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome"));
	}

	public Petition getPetition() {
		return petition;
	}

	public void setPetition(Petition petition) {
		this.petition = petition;
	}

	public List<Petition> getPetitionList() {
		return petitionList;
	}

	public void setPetitionList(List<Petition> petitionList) {
		this.petitionList = petitionList;
	}

	public PetionService getPetitionService() {
		return petitionService;
	}

	public void setPetitionService(PetionService petitionService) {
		this.petitionService = petitionService;
	}

	public PetitionAction getPetitionAction() {
		return petitionAction;
	}

	public void setPetitionAction(PetitionAction petitionAction) {
		this.petitionAction = petitionAction;
	}

	public boolean isFileUploadVisble() {
		return isFileUploadVisble;
	}

	public void setFileUploadVisble(boolean isFileUploadVisble) {
		this.isFileUploadVisble = isFileUploadVisble;
	}

}