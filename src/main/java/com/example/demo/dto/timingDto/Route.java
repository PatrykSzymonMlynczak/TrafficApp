
package com.example.demo.dto.timingDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Route {

    public String id;
    public List<Section> sections;

}
