package com.sibur.transport.mapper;

import com.sibur.transport.dto.OrderDTO;
import com.sibur.transport.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper( OrderMapper.class );

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "providerId", target = "provider.id")
    @Mapping(source = "vehicleId", target = "vehicle.id")
    @Mapping(source = "driverId", target = "driver.id")
    @Mapping(source = "transportTypeId", target = "transportType.id")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "provider.id", target = "providerId")
    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "transportType.id", target = "transportTypeId")
    OrderDTO toDTO(Order order);
}
