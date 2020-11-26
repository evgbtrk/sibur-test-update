package com.sibur.transport.controller;

import com.sibur.transport.dto.VehicleDTO;
import com.sibur.transport.mapper.VehicleMapper;
import com.sibur.transport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles().stream().map(VehicleMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<>(vehicleService.addVehicle(VehicleMapper.MAPPER.toEntity(vehicleDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(VehicleMapper.MAPPER.toDTO(
                    vehicleService.updateVehicle(id, VehicleMapper.MAPPER.toEntity(vehicleDTO)) ), HttpStatus.ACCEPTED);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable(name = "id") Long id) {
        try {
            vehicleService.deleteVehicle(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
