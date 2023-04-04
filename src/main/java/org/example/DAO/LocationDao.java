package org.example.DAO;

import org.example.Model.EandL;
import org.example.Model.Location;
import org.example.Model.User;

import java.util.List;
import java.util.Optional;

public interface LocationDao {
    Optional<Location> selectLocationId(String locationId);
    List<EandL> selectLocationAndEmployee(String locationId, String employee);
}
