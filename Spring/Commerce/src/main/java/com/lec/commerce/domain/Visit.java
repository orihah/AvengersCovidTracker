package com.lec.commerce.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
//creates the visit entity with getter and setter notation
@Entity
@Getter @Setter
public class Visit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
	
	private java.sql.Timestamp enterTime;
	private java.sql.Timestamp leaveTime;

	
}
