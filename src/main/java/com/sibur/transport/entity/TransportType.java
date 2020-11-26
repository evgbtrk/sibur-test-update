package com.sibur.transport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transport_types")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_type_id")
    private Long id;

    @Column(name = "title")
    private String title;
}
