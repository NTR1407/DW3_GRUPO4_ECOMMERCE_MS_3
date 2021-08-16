package com.ordenes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ordenes", schema = "ordenes")
public class Orden implements Serializable {

    private static final long serialVersionUID = -3319141437098805676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_USUARIO",  nullable = false)
    private Long idUsuario;

    @Column(name = "ID_PAIS",  nullable = false)
    private Long idPais;

    @Column(name = "ID_CIUDAD",  nullable = false)
    private Long idCiudad;

    @Column(name = "VALOR_TOTAL",  nullable = false)
    private Long valorTotal;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REG")
    private Date fechaReg;

    @Column(name = "CODIGO_SEGUIMIENTO")
    private String codigoSeguimiento;

    @Column(name = "IMPUESTOS",  nullable = false)
    private Long impuestos;

    @Column(name = "COSTOS_ENVIO",  nullable = false)
    private Long costoEnvio;

    @Column(name = "DIRECCION_ENVIO",  nullable = false)
    private String direccionEnvio;

}
