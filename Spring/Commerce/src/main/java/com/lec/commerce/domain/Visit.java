package com.lec.commerce.domain;

import java.util.List;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	private Timestamp enterTime;
	private Timestamp leaveTime;
	private boolean contact;

	public Visit() {

	}

	public Visit(Location location, Timestamp enterTime, Timestamp leaveTime, boolean contact) {

	}

	Visit CreateVisit(Location location, Timestamp enterTime, Timestamp leaveTime, boolean contact) {
		return new Visit(location, enterTime, leaveTime, contact);

	}

	Visit FinishVisit(Timestamp leaveTime, Visit visit) {
		visit.leaveTime = leaveTime;
		return visit;

	}

	void DeleteVisit(Visit visit) {
		visit = null;
	}

}
