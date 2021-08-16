package com.ordenes.util;

import com.ordenes.exception.MSTechnicalException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

public interface ITools {

    public static String getStringFechaJava(Date aFecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return aFecha != null ? formato.format(aFecha) : "";

    }

    public static Date getDateFechaJava(String aFecha) {
        Date fechaConvertida = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fechaConvertida = formato.parse(aFecha);
        } catch (Exception e) {
            throw new MSTechnicalException();
        }
        return fechaConvertida;
    }
    public static Object copiarPropiedadesObjetoAHaciaBIgnorandoNulosDeA(Object aOrigenA, Object aDestinoB) {
        String[] atributosIgnorados = getAtributosNulosDeObjeto(aOrigenA);
        BeanUtils.copyProperties(aOrigenA, aDestinoB, atributosIgnorados);
        return aDestinoB;
    }

    private static String[] getAtributosNulosDeObjeto(Object object) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(object);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }
}
