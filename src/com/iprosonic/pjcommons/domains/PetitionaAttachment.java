package com.iprosonic.pjcommons.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name = "petition_attachments")
public class PetitionaAttachment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="attachment_id")
	private Integer attachmentId;
	
	@Column(name="petition_id")
	private Integer petitionId;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="file_name")
	private String fileName;
	
         

	public Integer getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Integer getPetitionId() {
		return petitionId;
	}

	public void setPetitionId(Integer petitionId) {
		this.petitionId = petitionId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
