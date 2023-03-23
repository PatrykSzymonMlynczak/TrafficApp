
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LocationDto {

    public List<Item> items;

}
