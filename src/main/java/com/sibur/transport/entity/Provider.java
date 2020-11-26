package com.sibur.transport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "providers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
