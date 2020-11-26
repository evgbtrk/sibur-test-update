package com.sibur.transport.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String status;
    private String customerFullname;
    private String customerPhoneNumber;
    private Long customerId;
    private Long providerId;
    private Long vehicleId;
    private Long driverId;
    private Long transportTypeId;
}
