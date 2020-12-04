package com.lec.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.Location;
import com.lec.commerce.domain.User;
import com.lec.commerce.repo.LocationRepo;
import com.lec.commerce.repo.UserRepo;
@Service
@Transactional
public class LocationService {
	@Autowired 
	private LocationRepo locationrepo;
	
	//Service to add to databse
	public int join(Location location) {
		locationrepo.save(location);
		return location.getId();
	}
	public void fillLocations() {
        Location l1 = new Location();
        l1.setBuilding("WIC");
        l1.setFloor("1");
        l1.setName("Meeting Room A");
        locationrepo.save(l1);

        Location l2 = new Location();
        l2.setBuilding("MIC");
        l2.setFloor("2");
        l2.setName("Meeting Room B");
        locationrepo.save(l2);

        Location l3 = new Location();
        l3.setBuilding("WIC");
        l3.setFloor("1");
        l3.setName("Meeting Room C");
        locationrepo.save(l3);

        Location l4 = new Location();
        l4.setBuilding("WCM");
        l4.setFloor("1");
        l4.setName("Meeting Room D");
        locationrepo.save(l4);

        Location l5 = new Location();
        l5.setBuilding("MIC");
        l5.setFloor("1");
        l5.setName("Break Room 1");
        locationrepo.save(l5);

        Location l6 = new Location();
        l6.setBuilding("WCM");
        l6.setFloor("2");
        l6.setName("Break Room 2");
        locationrepo.save(l6);

        Location l7 = new Location();
        l6.setBuilding("MIC");
        l6.setFloor("3");
        l6.setName("Break Room 3");
        locationrepo.save(l7);

    }
}
