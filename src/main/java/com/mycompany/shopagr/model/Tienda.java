/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopagr.model;

import java.util.ArrayList;

/**
 *
 * @author Adr1
 */
public class Tienda implements Cloneable {

   
    private String nombre;
    private String direccion;
    private int precio;
    private String descripcion;
    private String coordenadas;
    private Categoria categoria;
    private Opcion opcion;
    private Promocion promocion;
   
    private boolean activo;
    private int id;

    public Tienda() {
      
        this.id = -1;
        this.nombre = nombre;
        this.direccion = "";
        this.activo = true;
        this.categoria = new Categoria();
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    
    
    public void setCategoria(Categoria cat) {
        this.categoria = cat;
    }
    public Opcion getOpcion() {
        return opcion;
    }
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    
    public Promocion getPromocion(){
        return this.promocion;
    }
    public void setPromocion(Promocion promo) {
        this.promocion = promo;
    }
    
   
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getCoordenadas(){
        return descripcion;
    }
    public void setCoordenadas(String coordenadas){
        this.coordenadas = coordenadas;
    }

    @Override
    public Object clone() {
        Tienda p = new Tienda();
        p.setId(id);
        p.setDireccion(direccion);
        p.setActivo(activo);
        p.setPrecio(precio);
        p.setCoordenadas(coordenadas);
        p.setDescripcion(descripcion);
        //copia superficial
        p.setPromocion(promocion);
        p.setOpcion(opcion);
        p.setCategoria(categoria);
      
       
        return p;
    }
}

