package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
    /**
     * Excepcion de servicios de Alquiler donde se recibe un mensaje y la excepcion concreta
     * @param message
     * @param e
     */
    public ExcepcionServiciosAlquiler(String message,Exception e){
        super(message,e);
    }

    /**
     * Excepcion de servicios de Alquiler donde solo se recibe un mensaje 
     * @param message
     */
    public ExcepcionServiciosAlquiler(String message){
        super(message);
    }
}
