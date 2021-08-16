package com.ordenes.service.impl;

import com.ordenes.model.Orden;
import com.ordenes.repository.IOrdenRepository;
import com.ordenes.service.interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl  implements IOrdenService {

    private IOrdenRepository ordenRepository;

    @Override
    public List<Orden> findAll() {
        return this.ordenRepository.findAll();
    }

    @Autowired
    public void setOrdenRepository(IOrdenRepository ordenRepository){
        this.ordenRepository = ordenRepository;
    }

}
