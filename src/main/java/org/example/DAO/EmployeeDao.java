package org.example.DAO;

import org.example.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> selectAllEmployee();
    List<Employee> selectEmployeeById(String employeeId);
    int inserEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId);
    int deleteEmployeeById(String employeeId);
    int updateEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId);
}
