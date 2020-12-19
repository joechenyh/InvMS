package com.nus.invms.domain;

import javax.validation.constraints.*;

public class Password {
	
	@NotEmpty
	@Size(min=5, max=20)
	private String newPassword;
	@NotEmpty
	@Size(min=5, max=20)
	private String confNewPassword;
	
	//@NotEmpty
	@Size(min = 5, max = 20)
	private String userName;
	@NotEmpty
	@Size(min = 5, max = 20)
	private String password;
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfNewPassword() {
		return confNewPassword;
	}

	public void setConfNewPassword(String confNewPassword) {
		this.confNewPassword = confNewPassword;
	}

	public Password(@NotEmpty @Size(min = 5, max = 20) String newPassword,
			@NotEmpty @Size(min = 5, max = 20) String confNewPassword,
			@NotEmpty @Size(min = 5, max = 20) String userName, @NotEmpty @Size(min = 5, max = 20) String password) {
		super();
		this.newPassword = newPassword;
		this.confNewPassword = confNewPassword;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Password [newPassword=" + newPassword + ", confNewPassword=" + confNewPassword + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
	
	
	

}
