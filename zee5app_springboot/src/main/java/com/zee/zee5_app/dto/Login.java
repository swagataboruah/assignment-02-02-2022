package com.zee.zee5_app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;
@Data
@ToString

@Entity 
@Table(name="login")

public class Login {
	

    public Login() {
		return;
	}
	
	
	@Id 
	@Column(name="userName")
	@Size(max=50)
	@NotBlank
	private String userName;
	@Size(max=100)
	@NotBlank
	private String password;
	@NotBlank
	private String regID;
	@NotBlank
	private ROLE role;
	
	
}