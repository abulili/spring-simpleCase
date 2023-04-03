package org.example.Service;

import org.example.DAO.EmployeeDao;
import org.example.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployDBService {
    private final EmployeeDao employeeDao;
    @Autowired
    public EmployDBService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> selectAllEmployee() {
        return employeeDao.selectAllEmployee();
    }
    public int inserEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId) {
        return employeeDao.inserEmployee(employeeId,employeeName,gender, age, baseSalary, locationId);
    }
    public int deleteEmployeeById(String employeeId){
        return employeeDao.deleteEmployeeById(employeeId);
    }
    public int updateEmployee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId) {
        return employeeDao.updateEmployee(employeeId,employeeName,gender, age, baseSalary, locationId);
    }
    public List<Employee> selectEmployeeById(String employeeId) {
        return employeeDao.selectEmployeeById(employeeId);
    }
}
