
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    public String label;
    public String countryCode;
    public String countryName;
    public String state;
    public String county;
    public String city;
    public String district;
    public String street;
    public String postalCode;
    public String houseNumber;

}
