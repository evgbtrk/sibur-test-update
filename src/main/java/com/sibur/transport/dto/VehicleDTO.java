package com.sibur.transport.dto;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;
    private String number;
    private String model;
    private Long transportTypeId;
    private Long providerId;
}
