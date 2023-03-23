
package com.example.demo.dto.locationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Scoring {

    public Float queryScore;
    public FieldScore fieldScore;

}
