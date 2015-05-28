package com.iprosonic.pjcommons.domains;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "petition")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String loginId;
	private String name;
	private String password;
	private String location;

	@Column(name = "userRole")
	private String userRole;

	/** default constructor */
	@Id
	@Column(name = "loginId", unique = true)
	public String getLoginId() {
		return loginId;
	}

	public User() {
		super();
	}

	/** full constructor */
	public User(String email, Role role, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	@Column(name = "email", unique = true, nullable = false, length = 90)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "location", nullable = false, length = 45)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}