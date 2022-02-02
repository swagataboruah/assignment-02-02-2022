package com.zee.zee5_app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "mov_Name")}, name = "movie")
@Entity 
public class Movie implements Comparable<Movie>{
	
	public Movie() {
		return;
	}
	
	
	@Id 
	@Column(name="movId")
	private String movId;
	@Size(max=50)
	@NotBlank
	private String mov_Name;
	@Max(value=70)
	private int age_limit_mov;
	@NotBlank
	private String cast_mov;
	@NotBlank
	private String genre_mov;
	@NotBlank
	private String length_mov;
	@NotBlank
	private String trailer_mov;
	@NotNull
	private String releasedate_mov;
	@NotNull
	private String language;
	@NotBlank
	private String regId;
	
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
