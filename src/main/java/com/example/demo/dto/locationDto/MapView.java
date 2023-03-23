
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapView {

    public Float west;
    public Float south;
    public Float east;
    public Float north;

}
