package com.ordenes.mapper;

import com.ordenes.dto.OrdenDTO;
import com.ordenes.model.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdenMapper {

        OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);

        // DTO's to Entitys

        @Mapping(target = "id", source = "id")
        Orden toOrden(OrdenDTO aOrdenDTO);

        // Entitys to DTO's

        @InheritInverseConfiguration
        @Mapping(target = "id", source = "idLiquidacionConcepto")

        OrdenDTO toOrdenDTO(Orden aOrden);

}
