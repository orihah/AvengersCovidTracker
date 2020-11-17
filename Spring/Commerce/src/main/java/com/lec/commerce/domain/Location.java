package com.lec.commerce.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
//Creates the entity class for location, with getters and setter annotation included
@Entity
@Getter @Setter
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String floor;
	private String building;
	
	
	@OneToMany(mappedBy = "location")
    List<Visit> visit;

}
