package com.iprosonic.pjcommons.domains;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Petiton entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "petition")
public class Petition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer petitionId;
	private Boolean groupGrievance;
	private String mobileNo;
	private String phoneNo;
	private String idProof;
	private String idNo;
	private String firNo;

	private String petitionStatus;
	private String petitionWith;
	private String petitionSubject;
	private String petitionDate;
	private String refNo;

	private String name;
	private String gender;
	private String fatherOrHusbandName;
	private String completeAddress;
	private Boolean ruralUrban;
	private String pinNo;
	private String district;
	private String blockOrPanchayatSamiti;
	private String gramPanchayat;
	private String grvDepartmentType;
	private String grvDepartment;
	private String grvSchemeService;
	private String grvCategory;
	private String grvIssue;
	private String grvDescription;
	private String petitionSource;
	private String sendTo;

	private Set<PetitionAction> petitionActionSet = new HashSet<PetitionAction>();

	@Column(name = "petition_status")
	public String getPetitionStatus() {
		return petitionStatus;
	}

	public void setPetitionStatus(String petitionStatus) {
		this.petitionStatus = petitionStatus;
	}

	@Column(name = "petition_with")
	public String getPetitionWith() {
		return petitionWith;
	}

	public void setPetitionWith(String petitionWith) {
		this.petitionWith = petitionWith;
	}

	@Column(name = "petition_subject", length = 2000)
	public String getPetitionSubject() {
		return petitionSubject;
	}

	public void setPetitionSubject(String petitionSubject) {
		this.petitionSubject = petitionSubject;
	}

	@Column(name = "petition_date")
	public String getPetitionDate() {
		return petitionDate;
	}

	public void setPetitionDate(String petitionDate) {
		this.petitionDate = petitionDate;
	}

	@Column(name = "ref_no")
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	// Constructors

	/** default constructor */
	public Petition() {
	}

	public Petition(Integer petitionId, Boolean groupGrievance,
			String mobileNo, String phoneNo, String idProof, String idNo,
			String name, String gender, String fatherOrHusbandName,
			String completeAddress, Boolean ruralUrban, String pinNo,
			String district, String blockOrPanchayatSamiti,
			String gramPanchayat, String grvDepartmentType,
			String grvDepartment, String grvSchemeService, String grvCategory,
			String grvIssue, String grvDescription) {
		super();

		this.groupGrievance = groupGrievance;
		this.mobileNo = mobileNo;
		this.phoneNo = phoneNo;
		this.idProof = idProof;
		this.idNo = idNo;
		this.name = name;
		this.gender = gender;
		this.fatherOrHusbandName = fatherOrHusbandName;
		this.completeAddress = completeAddress;
		this.ruralUrban = ruralUrban;
		this.pinNo = pinNo;
		this.district = district;
		this.blockOrPanchayatSamiti = blockOrPanchayatSamiti;
		this.gramPanchayat = gramPanchayat;
		this.grvDepartmentType = grvDepartmentType;
		this.grvDepartment = grvDepartment;
		this.grvSchemeService = grvSchemeService;
		this.grvCategory = grvCategory;
		this.grvIssue = grvIssue;
		this.grvDescription = grvDescription;
	}

	// Property accessors

	@Id
	@Column(name = "petition_Id", unique = true, nullable = false, length = 20)
	public Integer getPetitionId() {
		return this.petitionId;
	}

	public void setPetitionId(Integer petitionId) {
		this.petitionId = petitionId;
	}

	@Column(name = "group_grievance", length = 2000)
	public Boolean getGroupGrievance() {
		return this.groupGrievance;
	}

	public void setGroupGrievance(Boolean groupGrievance) {
		this.groupGrievance = groupGrievance;
	}

	@Column(name = "mobile_no", length = 12)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "phone_no", length = 12)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "id_proof", length = 100)
	public String getIdProof() {
		return this.idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "father_or_husband_name", length = 50)
	public String getFatherOrHusbandName() {
		return this.fatherOrHusbandName;
	}

	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}

	@Column(name = "complete_address", length = 1500)
	public String getCompleteAddress() {
		return this.completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	@Column(name = "rural_urban")
	public Boolean getRuralUrban() {
		return this.ruralUrban;
	}

	public void setRuralUrban(Boolean ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	@Column(name = "pin_no", length = 10)
	public String getPinNo() {
		return this.pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	@Column(name = "district", length = 30)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "block_or_panchayat_samiti", length = 30)
	public String getBlockOrPanchayatSamiti() {
		return this.blockOrPanchayatSamiti;
	}

	public void setBlockOrPanchayatSamiti(String blockOrPanchayatSamiti) {
		this.blockOrPanchayatSamiti = blockOrPanchayatSamiti;
	}

	@Column(name = "gram_panchayat", length = 30)
	public String getGramPanchayat() {
		return this.gramPanchayat;
	}

	public void setGramPanchayat(String gramPanchayat) {
		this.gramPanchayat = gramPanchayat;
	}

	@Column(name = "grv_department_type", length = 100)
	public String getGrvDepartmentType() {
		return this.grvDepartmentType;
	}

	public void setGrvDepartmentType(String grvDepartmentType) {
		this.grvDepartmentType = grvDepartmentType;
	}

	@Column(name = "grv_department", length = 100)
	public String getGrvDepartment() {
		return this.grvDepartment;
	}

	public void setGrvDepartment(String grvDepartment) {
		this.grvDepartment = grvDepartment;
	}

	@Column(name = "grv_scheme_service", length = 100)
	public String getGrvSchemeService() {
		return this.grvSchemeService;
	}

	public void setGrvSchemeService(String grvSchemeService) {
		this.grvSchemeService = grvSchemeService;
	}

	@Column(name = "grv_category", length = 100)
	public String getGrvCategory() {
		return this.grvCategory;
	}

	public void setGrvCategory(String grvCategory) {
		this.grvCategory = grvCategory;
	}

	@Column(name = "grv_issue", length = 100)
	public String getGrvIssue() {
		return this.grvIssue;
	}

	public void setGrvIssue(String grvIssue) {
		this.grvIssue = grvIssue;
	}

	@Column(name = "grv_description", length = 1000, nullable = true ,columnDefinition = "mediumtext")
	public String getGrvDescription() {
		return this.grvDescription;
	}

	public void setGrvDescription(String grvDescription) {
		this.grvDescription = grvDescription;
	}

	@Column(name = "id_no", length = 100)
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@Column(name = "petition_source", length = 100)
	public String getPetitionSource() {
		return petitionSource;
	}

	public void setPetitionSource(String petitionSource) {
		this.petitionSource = petitionSource;
	}

	@Column(name = "firNo_no", length = 100)
	public String getFirNo() {
		return firNo;
	}

	public void setFirNo(String firNo) {
		this.firNo = firNo;
	}

	@Column(name = "send_to", length = 100)
	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "petitionId")
	
	public Set<PetitionAction> getPetitionActionSet() {
		return petitionActionSet;
	}

	public void setPetitionActionSet(Set<PetitionAction> petitionActionSet) {
		this.petitionActionSet = petitionActionSet;
	}

	// Fields

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((petitionId == null) ? 0 : petitionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Petition other = (Petition) obj;
		if (petitionId == null) {
			if (other.petitionId != null)
				return false;
		} else if (!petitionId.equals(other.petitionId))
			return false;
		return true;
	}

}