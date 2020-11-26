package com.sibur.transport.controller;

import com.sibur.transport.dto.TransportTypeDTO;
import com.sibur.transport.entity.TransportType;
import com.sibur.transport.mapper.TransportTypeMapper;
import com.sibur.transport.service.TransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transport_types")
public class TransportTypeController {
    private TransportTypeService transportTypeService;

    @Autowired
    public void setTransportTypeService(TransportTypeService transportTypeService) {
        this.transportTypeService = transportTypeService;
    }

    @GetMapping
    public List<TransportTypeDTO> getTransportTypes() {
        return transportTypeService.getAllTransportTypes().stream().map(TransportTypeMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long getAllTranspoortTypes(@RequestBody TransportTypeDTO transportTypeDTO) {
        return transportTypeService.addTransportType(TransportTypeMapper.MAPPER.toEntity(transportTypeDTO));
    }
}
