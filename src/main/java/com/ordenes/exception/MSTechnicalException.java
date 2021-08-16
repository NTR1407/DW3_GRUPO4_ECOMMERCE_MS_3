package com.ordenes.exception;

public class MSTechnicalException extends RuntimeException{

    private static final long serialVersionUID = -3983711110801954411L;

    private static final String MENSAJE_PROBLEMAS_TECNICOS = "Problemas técnicos. contacte administrador";

    public MSTechnicalException() { super(MENSAJE_PROBLEMAS_TECNICOS); }
}
