package com.iprosonic.pjcommons.domains;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "petition_action_taken")
public class PetitionAction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 322447597289677246L;

	public PetitionAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetitionAction(Integer petitionActionId, Integer petitionId,
			String actionTaken, String actionDate, String actionTakenBy,
			Petition petition) {
		super();
		this.petitionActionId = petitionActionId;
		this.petitionId = petitionId;
		this.actionTaken = actionTaken;
		this.setActionDate(actionDate);
		this.actionTakenBy = actionTakenBy;
		this.petition = petition;
	}

	@Id
	@Column(name = "petition_action_id", unique = true, nullable = false, length = 20)
	private Integer petitionActionId;

	@Column(name = "petition_id")
	private Integer petitionId;

	@Column(name = "action_taken", length = 2000)
	private String actionTaken;

	@Column(name = "action_date")
	private String actionDate;

	@Column(name = "action_taken_by")
	private String actionTakenBy;
	
	@Column(name = "location")
	private String   location;
	

	private Petition petition;

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getActionTakenBy() {
		return actionTakenBy;
	}

	public void setActionTakenBy(String actionTakenBy) {
		this.actionTakenBy = actionTakenBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "petition_Id", nullable = false, insertable = false, updatable = false)
	public Petition getPetition() {
		return petition;
	}

	public void setPetition(Petition petition) {
		this.petition = petition;
	}

	public Integer getPetitionId() {
		return petitionId;
	}

	public void setPetitionId(Integer petitionId) {
		this.petitionId = petitionId;
	}

	public Integer getPetitionActionId() {
		return petitionActionId;
	}

	public void setPetitionActionId(Integer petitionActionId) {
		this.petitionActionId = petitionActionId;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
