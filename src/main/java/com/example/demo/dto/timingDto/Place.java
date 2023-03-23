
package com.example.demo.dto.timingDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Place {

    public String type;
    public Location location;
    public OriginalLocation originalLocation;

}
