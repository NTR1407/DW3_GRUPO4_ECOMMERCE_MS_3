package com.ordenes.service.impl;

import com.ordenes.exception.MSDataNotFoundException;
import com.ordenes.model.Orden;
import com.ordenes.repository.IOrdenRepository;
import com.ordenes.service.interfaces.IOrdenService;
import com.ordenes.util.ITools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdenServiceImpl  implements IOrdenService {

    private IOrdenRepository ordenRepository;

    @Override
    public List<Orden> findAll() {
        return this.ordenRepository.findAll();
    }

    @Override
    public Orden findById(Long aId) {
        return this.ordenRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Orden createOrden(Orden aOrden) {
        aOrden.setFechaReg(ITools.getDateFechaJava(ITools.getStringFechaJava(new Date())));
        return this.ordenRepository.save(aOrden);
    }

    @Override
    @Transactional
    public Orden updateOrden(Orden aOrden) {
        Orden ordenBD = this.ordenRepository.findById(aOrden.getId()).orElseThrow(() -> new MSDataNotFoundException("No se encontro una cuenta con el userId: " + aOrden.getId()));
        ITools.copiarPropiedadesObjetoAHaciaBIgnorandoNulosDeA(aOrden, ordenBD);
        ordenBD.setFechaReg(aOrden.getFechaReg());
        ordenBD.setCodigoSeguimiento(aOrden.getCodigoSeguimiento());
        return this.ordenRepository.save(ordenBD);
    }


    @Override
    @Transactional
    public void deleteOrden(Long aId) {
        Orden ordenBD = this.ordenRepository.findById(aId).orElseThrow(() -> new MSDataNotFoundException("No se encontro una cuenta con el userId: " + aId));

        this.ordenRepository.deleteById(ordenBD.getId());
    }


    @Autowired
    public void setOrdenRepository(IOrdenRepository ordenRepository){
        this.ordenRepository = ordenRepository;
    }

}
