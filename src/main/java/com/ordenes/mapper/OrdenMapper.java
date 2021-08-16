package com.ordenes.mapper;

import com.ordenes.dto.OrdenDTO;
import com.ordenes.model.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdenMapper {

        OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);

        // DTO's to Entitys
        @Mappings({
                @Mapping(target = "id", source = "id"),
                @Mapping(target = "idUsuario", source = "idUsuario"),
                @Mapping(target = "idPais", source = "idPais"),
                @Mapping(target = "idCiudad", source = "idCiudad"),
                @Mapping(target = "valorTotal", source = "valorTotal"),
                @Mapping(target = "fechaReg", source = "fechaReg"),
                @Mapping(target = "codigoSeguimiento", source = "codigoSeguimiento"),
                @Mapping(target = "impuestos", source = "impuestos"),
                @Mapping(target = "costoEnvio", source = "costoEnvio"),
                @Mapping(target = "direccionEnvio", source = "direccionEnvio")
        })
        Orden toOrden(OrdenDTO aOrdenDTO);

        // Entitys to DTO's

        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "id", source = "id"),
                @Mapping(target = "idUsuario", source = "idUsuario"),
                @Mapping(target = "idPais", source = "idPais"),
                @Mapping(target = "idCiudad", source = "idCiudad"),
                @Mapping(target = "valorTotal", source = "valorTotal"),
                @Mapping(target = "fechaReg", source = "fechaReg"),
                @Mapping(target = "codigoSeguimiento", source = "codigoSeguimiento"),
                @Mapping(target = "impuestos", source = "impuestos"),
                @Mapping(target = "costoEnvio", source = "costoEnvio"),
                @Mapping(target = "direccionEnvio", source = "direccionEnvio")
        })
        OrdenDTO toOrdenDTO(Orden aOrden);

}
