package com.sibur.transport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_fullname")
    private String customerFullname;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Transient
    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private Provider provider;

    @Transient
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @Transient
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "transport_type_id", referencedColumnName = "transport_type_id")
    private TransportType transportType;
}
