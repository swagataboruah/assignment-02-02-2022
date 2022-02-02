package com.zee.zee5_app.dto;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import lombok.*;
@Data
@Setter
@Getter
@ToString
@AllArgsConstructor

@Entity //entity class is used for ORM
//this register class we want to use for ORM mapping so mark Entity
@Table(name="register")
//jpa creates table and we can customize it using Table name

public class Register implements Comparable<Register> {


     public Register() {
		return;
	}
	
	@Id // it will consider this column as PK
	//all the camel naming conventions are converted to snake case ie. underscore is added
	//for that 
	@Column(name="regId")
	private String id;
	@Size(max=50)
	@NotBlank
	private String firstName;
	@Size(max=50)
	@NotBlank
    private String lastName;
	@Size(max=50)
	@Email
	private String Email;
	@Size(max=100) //larger size as we will store encrypted pwd
	@NotBlank
	private String password;
	//@NotBlank
	private BigDecimal ContactNumber; //it is bigdecimal so dont fix size
	

	@Override
	// purpose of compare to compare on the basis of id string
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}


	
	
}