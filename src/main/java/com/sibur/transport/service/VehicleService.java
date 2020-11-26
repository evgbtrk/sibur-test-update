package com.sibur.transport.service;

import com.sibur.transport.entity.Vehicle;
import com.sibur.transport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) throws ChangeSetPersister.NotFoundException {
        vehicleRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) throws ChangeSetPersister.NotFoundException {
        vehicleRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }
}
