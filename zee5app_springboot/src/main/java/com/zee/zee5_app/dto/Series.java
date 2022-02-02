package com.zee.zee5_app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "ser_Name")}, name = "series")
@Entity 
public class Series implements Comparable<Series> {
	

    public Series() {
		return;
	}
	
	
	@Id 
	@Column(name="serId")
	private String serId;
	@NotBlank
	private String trailer_ser;
	@NotBlank
	private String ser_Name;	
	@Max(value=70)
	private int age_limit_ser;
	@NotBlank
	private String cast_ser;
	@NotBlank
	private String genre_ser;
	@NotNull
	private String releasedate_ser;
	@NotNull
	private String language;
	@Min(value=1)
	private int num_episodes;
	@NotBlank
	private String regId;
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
