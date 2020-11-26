package com.sibur.transport.controller;
import com.sibur.transport.entity.Driver;
import com.sibur.transport.entity.Provider;
import com.sibur.transport.service.DriverService;
import com.sibur.transport.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private DriverService driverService;
    private ProviderService providerService;

    @Autowired
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping
    public ResponseEntity<?> addDriver(@RequestBody Map<String, String> request) {
        System.out.println(request);
        return null;
        //return new ResponseEntity<>(driverService.addDriver(driver), HttpStatus.CREATED);
    }
}
