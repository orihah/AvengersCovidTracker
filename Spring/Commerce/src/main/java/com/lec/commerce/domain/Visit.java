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
	
	private Timestamp enterTime;
	private Timestamp leaveTime;
	private boolean contact;
	
	public Visit()
	{
		
	}
	public Visit( Location location, Timestamp enterTime, Timestamp leaveTime, boolean contact)
	{
		
	}
	void CreateVisit(Location location, Timestamp enterTime,Timestamp leaveTime, boolean contact )
	{
		this.enterTime = enterTime;
		this.leaveTime = leaveTime;
		this.location = location;
		this.contact = contact;
	}
	

	
	void SetLocation(Location location, Visit visit)
	{
		
	}
	
	Visit FinishVisit(Timestamp leaveTime, Visit visit)
	{
		return visit;
		
		
		
	}
	
	void DeleteVisit(Visit visit)
	{
		
	}
	public void setUser(User user2) {
		// TODO Auto-generated method stub
		this.user = user2;
	}
	public void setLocation(Location location2) {
		// TODO Auto-generated method stub
		
	}
	public void setEnterTime(Timestamp timestamp) {
		// TODO Auto-generated method stub
		this.enterTime = timestamp;
	}
	public void setLeaveTime(Timestamp timestamp) {
		// TODO Auto-generated method stub
		this.leaveTime = timestamp;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
