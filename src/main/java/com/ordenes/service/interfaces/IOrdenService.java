package com.ordenes.service.interfaces;

import com.ordenes.model.Orden;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrdenService {
    List<Orden> findAll();
}
