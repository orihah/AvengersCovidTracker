package com.lec.commerce.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String Name;
	
	@OneToMany(mappedBy = "location")
    Set<Visit> visits;

}