
package com.example.demo.dto.timingDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Timing {

    public List<Route> routes;

}
