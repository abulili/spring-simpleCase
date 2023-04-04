package org.example.DAO;

import org.example.Model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("Employee")
@Component
public class EmployeeDaoAccessService implements EmployeeDao{
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Employee> selectAllEmployee() {
        final String sql = """
               select * from employee;
                """;
        List<Employee> EmployeeList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new Employee(
                    resultSet.getString("employeeId"),
                    resultSet.getString("employeeName"),
                    resultSet.getString("gender"),
                    resultSet.getString("age"),
                    resultSet.getString("baseSalary"),
                    resultSet.getString("locationId")
            );
        });
        return EmployeeList;
    }
    @Override
    public int inserEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId) {
        final String sql = """
                insert into employee value(?,?,?,?,?,?);
                """;
        int result = jdbcTemplate.update(sql, employeeId, employeeName, gender, age, baseSalary, locationId);
        if(result > 0) {
            System.out.println("A new row has been inserted");
        }
        else {
            System.out.println("Insert failed");
        }
        return result;
    }
    @Override
    public int deleteEmployeeById(String employeeId) {
        final String sql = """
                delete from employee where employeeId = ?
                """;
        return jdbcTemplate.update(sql, employeeId);
    }

    @Override
    public int updateEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId) {
        final String sql = """
               update employee set employeeName = ? , gender = ? , age = ? , baseSalary = ? , locationId = ? where employeeId = ?;
                """;
        return jdbcTemplate.update(sql, employeeName, gender, age, baseSalary, locationId, employeeId);
    }

    @Override
    public List<Employee> selectEmployeeById(String employeeId){
        final String sql = """
               select * from employee where employeeId = ?;
                """;
        List<Employee> employeeList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new Employee(
                    resultSet.getString("employeeId"),
                    resultSet.getString("employeeName"),
                    resultSet.getString("gender"),
                    resultSet.getString("age"),
                    resultSet.getString("baseSalary"),
                    resultSet.getString("locationId")
            );
        }, employeeId);
        return employeeList;
    }
}
