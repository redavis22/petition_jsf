package com.iprosonic.pjcommons.login.web.jsf;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.iprosonic.master.user.service.UserService;
import com.iprosonic.pjcommons.domains.User;
import com.iprosonic.pjcommons.utils.SessionUtil;

@ManagedBean
public class LoginBean implements Serializable {
	UserService userService = new UserService();
	private static final long serialVersionUID = 1L;
	private String password;
	private String message, uname, location;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String loginProject() 
	{
		
		if (userService.authenticateUser(uname, password, location)) {
			HttpSession session = SessionUtil.getSession();
		    User user=	userService.findByUser(uname);
			session.setAttribute("username", uname);
			session.setAttribute("name",user.getName());			
			session.setAttribute("location", location);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", session);
			return "/index.xhtml?faces-redirect=true";
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
					"invalid id"));
			return "/login.xhtml";
		}
	}

	public String logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		return "/login.xhtml";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}