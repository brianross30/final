package com.byrsolutions.hemofiliapp;

import java.util.Date;

/**
 * Created by 43446720 on 1/6/2018.
 */

public class Dato {
    private Date FechaInfusion;

    private String Marca;

    public Date getFechaInfusion() {
        return FechaInfusion;
    }

    public void setFechaInfusion(Date FechaInfusion) {
        this.FechaInfusion = FechaInfusion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
    }

    public String getProfilaxisDemanda() {
        return ProfilaxisDemanda;
    }

    public void setProfilaxisDemanda(String ProfilaxisDemanda) {
        this.ProfilaxisDemanda = ProfilaxisDemanda;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getLote1() {
        return Lote1;
    }

    public void setLote1(String Lote1) {
        this.Lote1 = Lote1;
    }

    public Date getFechaVencimiento1() {
        return FechaVencimiento1;
    }

    public void setFechaVencimiento1(Date FechaVencimiento1) {
        this.FechaVencimiento1 = FechaVencimiento1;
    }

    public int getPotencia1() {
        return Potencia1;
    }

    public void setPotencia1(int Potencia1) {
        this.Potencia1 = Potencia1;
    }

    public String getLote2() {
        return Lote2;
    }

    public void setLote2(String Lote2) {
        this.Lote2 = Lote2;
    }

    public Date getFechaVencimiento2() {
        return FechaVencimiento2;
    }

    public void setFechaVencimiento2(Date FechaVencimiento2) {
        this.FechaVencimiento2 = FechaVencimiento2;
    }

    public int getPotencia2() {
        return Potencia2;
    }

    public void setPotencia2(int Potencia2) {
        this.Potencia2 = Potencia2;
    }

    private int Unidades;

    private String ProfilaxisDemanda;

    private String Motivo;

    private String Observaciones;

    private String Lote1;

    private Date FechaVencimiento1;

    private int Potencia1;

    private String Lote2;

    private Date FechaVencimiento2;

    private int Potencia2;

}
