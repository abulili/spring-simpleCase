package org.example.Model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Location {
    @NotBlank
    private String locationId, locationName, latitude, longtitude;
}
