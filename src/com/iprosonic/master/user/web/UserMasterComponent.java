package com.iprosonic.master.user.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iprosonic.master.user.service.UserService;
import com.iprosonic.pjcommons.domains.User;

@ManagedBean(name = "userMasterComponent")
@SessionScoped
public class UserMasterComponent {

	private User		user		= new User();
	private UserService	userService	= new UserService();
	private List<User>	userList;

	@PostConstruct
	public String createUser() {
		setUser(new User());
		return "/jsf/user/createUser.xhtml";

	}

	public String userList() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String location = request.getSession().getAttribute("location").toString();
		setUserList(userService.listUser(location));
		return "/jsf/user/listUsers.xhtml";

	}

	public String editUser(User user) {

		try {

			user = userService.findByUser(user.getLoginId());
			setUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsf/user/editUser.xhtml";
	}

	public void saveUser(User user) {

		try {
			userService.saveUser(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "User successfully created"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Login id exists"));
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {

		try {
			userService.updateUser(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "User successfully created"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
