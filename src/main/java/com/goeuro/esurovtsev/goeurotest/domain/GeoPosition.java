package com.goeuro.esurovtsev.goeurotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoPosition {
    private double latitude;
    private double longitude;
}
