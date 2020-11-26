package com.sibur.transport.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "model")
    private String model;

    @ManyToOne()
    @JoinColumn(name = "transport_type_id")
    private TransportType transportType;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
}
