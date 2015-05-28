package com.iprosonic.pjcommons.navigation.web.jsf;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//--------------------------------------Masters----------------------------------------------
	public String moveToUserMaster() {
		System.out.println("-----------------moveToUserMaster()--------------------");
		return "/jsf/aclmasteruser/createAclMastersUser.xhtml";
	}
	
	public String moveToListAllUser() {
		System.out.println("-----------------moveToListAllUser()--------------------");
		return "/jsf/aclmastersuser/listAclMastersUsers.xhtml";
		
	}
	

	//--------------------------------------Commons----------------------------------------------
	public String moveToHomePage() {
		System.out.println("-----------------moveToHomePage()--------------------");
		return "/index.xhtml";
	}
	
	//--------------------------------------Petition----------------------------------------------
	public String moveToCreatePetitionPage() {
		System.out.println("-----------------moveTocreatePetitionPage()--------------------");
		return "/jsf/petiton/createPetiton.xhtml";
	}
	
	public String moveToListAllPetitionsPage() {
		System.out.println("-----------------moveToListAllPetitionsPage()--------------------");
		return "/jsf/petiton/listPetitons.xhtml";
	}
	
	
}