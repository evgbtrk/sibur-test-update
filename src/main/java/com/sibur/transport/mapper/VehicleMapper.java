package com.sibur.transport.mapper;

import com.sibur.transport.dto.VehicleDTO;
import com.sibur.transport.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper MAPPER = Mappers.getMapper( VehicleMapper.class );

    @Mapping(source = "transportTypeId", target = "transportType.id")
    @Mapping(source = "providerId", target = "provider.id")
    Vehicle toEntity(VehicleDTO vehicleDTO);

    @Mapping(source = "transportType.id", target = "transportTypeId")
    @Mapping(source = "provider.id", target = "providerId")
    VehicleDTO toDTO(Vehicle vehicle);
}
