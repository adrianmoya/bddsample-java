package com.adrianmoya.bddsample.jsf.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Index implements Serializable{
    private Integer numero1;
    private Integer numero2;
    private String mensaje;
    
    public String calcular(){
        int resultado = this.getNumero1() + this.getNumero2();
        this.setMensaje("El resultado es " + String.valueOf(resultado));
        return "index";
    }

 
    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    /**
     * @return the numero1
     */
    public Integer getNumero1() {
        return numero1;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    /**
     * @return the numero2
     */
    public Integer getNumero2() {
        return numero2;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }
    
    
}
