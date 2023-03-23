
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Item {

    public String title;
    public String id;
    public String resultType;
    public String houseNumberType;
    public Address address;
    public Position position;
    public List<Access> access;
    public MapView mapView;
    public Scoring scoring;

}
