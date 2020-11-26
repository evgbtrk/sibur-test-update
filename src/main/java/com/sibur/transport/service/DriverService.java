package com.sibur.transport.service;

import com.sibur.transport.entity.Driver;
import com.sibur.transport.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }
}
