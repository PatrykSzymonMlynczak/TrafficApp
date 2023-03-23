
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FieldScore {

    public Float city;
    public List<Float> streets;
    public Float houseNumber;

}
