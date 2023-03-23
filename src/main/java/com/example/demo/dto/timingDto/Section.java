
package com.example.demo.dto.timingDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Section {

    public String id;
    public String type;
    public Departure departure;
    public Arrival arrival;
    public Summary summary;
    public Transport transport;

}
