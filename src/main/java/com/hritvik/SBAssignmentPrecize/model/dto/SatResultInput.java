package com.hritvik.SBAssignmentPrecize.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SatResultInput {

    private String name;
    private String address;
    private String city;
    private String country;
    private String pinCode;
    private Integer satScore;
}
