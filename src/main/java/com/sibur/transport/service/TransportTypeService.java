package com.sibur.transport.service;

import com.sibur.transport.entity.TransportType;
import com.sibur.transport.repository.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportTypeService {
    private TransportTypeRepository transportTypeRepository;

    @Autowired
    public void setTransportTypeRepository(TransportTypeRepository transportTypeRepository) {
        this.transportTypeRepository = transportTypeRepository;
    }

    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }

    public Long addTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType).getId();
    }
}
