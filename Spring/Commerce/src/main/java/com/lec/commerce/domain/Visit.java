package com.lec.commerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Visit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    User user;
	
	@ManyToOne
    @JoinColumn(name = "location_id")
    Location location;
	
	private java.sql.Timestamp enterTime;
	private java.sql.Timestamp leaveTime;
	
}
