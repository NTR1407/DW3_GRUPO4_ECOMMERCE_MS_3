package com.ordenes.controller;

import com.ordenes.dto.OrdenDTO;
import com.ordenes.mapper.OrdenMapper;
import com.ordenes.model.Orden;
import com.ordenes.service.interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private IOrdenService ordenService;

    @GetMapping("/all")
    public ResponseEntity<List<OrdenDTO>> findAll() {
        List<Orden> ordenList = this.ordenService.findAll();
        if (ordenList == null || ordenList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenList.stream()
                .map(OrdenMapper.INSTANCE::toOrdenDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Autowired
    public void setOrdenService(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }
}
