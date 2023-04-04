package org.example.Model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EandL {
    @NotBlank
    private String locationName,latitude,longitude,employeeName,gender,baseSalary;

    public EandL(String locationName, String latitude, String longitude, String employeeName, String gender, String baseSalary) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.employeeName = employeeName;
        this.gender = gender;
        this.baseSalary = baseSalary;
    }
}
