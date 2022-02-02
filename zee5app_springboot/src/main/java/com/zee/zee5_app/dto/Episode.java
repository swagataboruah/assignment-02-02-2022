package com.zee.zee5_app.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Setter
@Getter
@ToString
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "epi_Name")}, name = "episode")
@Entity 
public class Episode {


    public Episode() {
		return;
	}
	
	
	
	@Id
	@Column(name="episode")
	private String epiId;
	@NotNull
	private String len_epi;
	@NotBlank
	private String serId;
	@NotBlank
	private String epi_Name;
	@NotBlank
	private String location_epi;
	@NotBlank
	private String trailer_epi;
	
}
