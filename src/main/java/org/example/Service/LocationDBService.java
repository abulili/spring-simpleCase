package org.example.Service;

import org.example.DAO.EmployeeDao;
import org.example.DAO.LocationDao;
import org.example.Model.EandL;
import org.example.Model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationDBService {
    private final LocationDao locationDao;

    @Autowired
    public LocationDBService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    public Optional<Location> selectLocationId(String locationId){
        return locationDao.selectLocationId(locationId);
    }
     public List<EandL> selectLocationAndEmployee(String locationId, String employeeId) {
        return locationDao.selectLocationAndEmployee(locationId, employeeId);
    }
    public List<Location> showAllLocation(){
        return locationDao.showAllLocation();
    }
}
