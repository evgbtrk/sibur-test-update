package com.sibur.transport.mapper;

import com.sibur.transport.dto.TransportTypeDTO;
import com.sibur.transport.entity.TransportType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransportTypeMapper {
    TransportTypeMapper MAPPER = Mappers.getMapper(TransportTypeMapper.class);

    @Mapping(source = "id", target = "transportTypeId")
    TransportTypeDTO toDTO(TransportType transportType);

    @Mapping(source = "transportTypeId", target = "id")
    TransportType toEntity(TransportTypeDTO transportTypeDTO);
}
