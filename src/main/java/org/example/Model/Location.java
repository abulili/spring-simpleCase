package org.example.Model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Location {
    @NotBlank
    private String locationId, locationName, latitude, longitude;

    public Location(String locationId, String locationName, String latitude, String longitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
