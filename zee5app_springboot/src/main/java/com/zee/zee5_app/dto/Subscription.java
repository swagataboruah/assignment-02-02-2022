package com.zee.zee5_app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@Entity 
@Table(name="subscription")
public class Subscription implements Comparable<Subscription>
{

    public Subscription() {
		return;
	}
	
	@Id 
	@Column(name="subId")
	private String SubId;
	@NotBlank
	private String Sub_Type;
	@NotNull
	private String Amount;
	@NotBlank
	private String StatusMode;
	@NotBlank
	private String PaymentMode;
	@NotBlank
	private String AutoRenew;
	@NotNull
	private String Dop;
	@NotNull
	private String Doe;
	@NotBlank
	private String RegID;
	

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return 0;
	}






}



