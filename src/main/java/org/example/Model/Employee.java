package org.example.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
public class Employee {
    @NotBlank
    private String employeeId, employeeName, gender, age, baseSalary, locationId;

    public Employee(String employeeId, String employeeName, String gender, String age, String baseSalary, String locationId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.age = age;
        this.baseSalary = baseSalary;
        this.locationId = locationId;
    }
}
