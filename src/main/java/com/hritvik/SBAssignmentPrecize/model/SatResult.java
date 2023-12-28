package com.hritvik.SBAssignmentPrecize.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class SatResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;
        @Column(unique = true)
        private String name;
        private String address;
        private String city;
        private String country;
        private String pinCode;
        private Integer satScore;
        private boolean isPassed;





}
