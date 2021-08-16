package com.ordenes.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ordenes.util.IConstantes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrdenDTO implements Serializable {

    private static final long serialVersionUID = 3865858517194322644L;

    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idPais;

    @NotNull
    private Long idCiudad;

    @NotNull
    private Long valorTotal;

    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaReg;

    private String codigoSeguimiento;

    @NotNull
    private Long impuestos;

    @NotNull
    private Long costoEnvio;

    @NotNull
    private String direccionEnvio;
}
