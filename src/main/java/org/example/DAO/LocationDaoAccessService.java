package org.example.DAO;

import org.example.Model.EandL;
import org.example.Model.Location;
import org.example.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository("Location")
@Component
public class LocationDaoAccessService implements LocationDao{
    private final JdbcTemplate jdbcTemplate;
    public LocationDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<Location> selectLocationId(String locationId){
        final String sql = """
               select * from location where locationId = ?;
                """;
        List<Location> locationList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new Location (
                    resultSet.getString("locationId"),
                    resultSet.getString("locationName"),
                    resultSet.getString("latitude"),
                    resultSet.getString("longitude")
            );
        }, locationId);
        return locationList.stream().findFirst();
    }
    @Override
    public List<EandL> selectLocationAndEmployee(String locationId, String employeeId) {
        final String sql = """
               select locationName,latitude,longitude,employeeName,gender,baseSalary from location, employee where location.locationId = employee.locationId and employee.employeeId = ?;
                """;
        List<EandL> EandLList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new EandL(
                    resultSet.getString("locationName"),
                    resultSet.getString("latitude"),
                    resultSet.getString("longitude"),
                    resultSet.getString("employeeName"),
                    resultSet.getString("gender"),
                    resultSet.getString("baseSalary")
            );
        }, employeeId);
        return EandLList;
    }
    @Override
    public List<Location> showAllLocation(){
        final String sql = """
               select * from location;
                """;
        List<Location> locationList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new Location (
                    resultSet.getString("locationId"),
                    resultSet.getString("locationName"),
                    resultSet.getString("latitude"),
                    resultSet.getString("longitude")
            );
        });
        return locationList;
    }
}
