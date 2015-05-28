package com.iprosonic.pjcommons.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Seq entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sequence", catalog = "petition")
public class Sequence implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4223084176353032179L;
	
	@Id
	@Column(name = "seqType", unique = true, nullable = false,length=20)
	
	private String seqType;
	@Column(name = "latestNo")
	private Long latestNo;

	// Constructors

	/** default constructor */
	public Sequence() {
	}

	/** full constructor */
	public Sequence(String seqType, Long latestNo) {
		this.seqType = seqType;
		this.latestNo = latestNo;
	}

	

	@Column(name = "seq_type", length = 45)
	public String getSeqType() {
		return this.seqType;
	}

	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}

	@Column(name = "latest_no")
	public Long getLatestNo() {
		return this.latestNo;
	}

	public void setLatestNo(Long latestNo) {
		this.latestNo = latestNo;
	}

	
}