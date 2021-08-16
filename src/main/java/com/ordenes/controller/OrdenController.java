package com.ordenes.controller;

import com.ordenes.dto.OrdenDTO;
import com.ordenes.mapper.OrdenMapper;
import com.ordenes.model.Orden;
import com.ordenes.service.interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private IOrdenService ordenService;

    @GetMapping("/all")
    public ResponseEntity<List<OrdenDTO>> findAll()
    {
        List<Orden> ordenList = this.ordenService.findAll();
        if (ordenList == null || ordenList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenList.stream()
                .map(OrdenMapper.INSTANCE::toOrdenDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OrdenDTO> findById(@PathVariable(value = "id", required = true) Long aId)
    {
        Orden orden = this.ordenService.findById(aId);
        if (orden == null) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(OrdenMapper.INSTANCE.toOrdenDTO(orden), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrdenDTO> createOrden( @Valid @RequestBody OrdenDTO aOrdenDTO)
    {
        Orden orden = this.ordenService.createOrden(OrdenMapper.INSTANCE.toOrden(aOrdenDTO));
        orden.setId(null);
        return new ResponseEntity<>(OrdenMapper.INSTANCE.toOrdenDTO(orden),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrdenDTO> updateOrden(@Valid @RequestBody OrdenDTO aOrdenDTO)
    {
        Orden orden =  this.ordenService.updateOrden(OrdenMapper.INSTANCE.toOrden(aOrdenDTO));
        orden.setId(null);
        return new ResponseEntity<>(OrdenMapper.INSTANCE.toOrdenDTO(orden),HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteOrden(@PathVariable(value = "id", required = true) Long aId) {
        this.ordenService.deleteOrden(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Autowired
    public void setOrdenService(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }
}
