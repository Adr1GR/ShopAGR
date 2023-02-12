/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopagr.controller;

import com.mycompany.shopagr.model.Opcion;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Optional;

/**
 *
 * @author Adr1
 */
@Named
@ApplicationScoped
public class OpcionController extends AbstractController<Opcion> {

    @Inject
    TiendaController propiedadcontroller;

    public OpcionController() {
        super(Opcion::new);

    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);

        this.getSelected().setNombre("Alquiler");
        this.add();

        this.create();
        this.getSelected().setActivo(true);

        this.getSelected().setNombre("Venta");
        this.add();

        this.create();
        this.getSelected().setActivo(true);

        this.getSelected().setNombre("Compartir");
        this.add();
    }
    public Opcion findById(int id){
        Optional<Opcion> o=null;
       o=this.getItems().stream().filter(
               item -> {
                return item.getId() == id;
           }).findFirst();
       if(o.isEmpty())
           return null;
       else
           return o.get();
    }
      public Opcion findByName(String name){
        Optional<Opcion> o=null;
       o=this.getItems().stream().filter(
               item -> {
                return item.getNombre().equals(name);
           }).findFirst();
       if(o.isEmpty())
           return null;
       else
           return o.get();
    }
      
    public String remove() {
        if (this.getSelected() != null) {
            if (this.propiedadcontroller.getItems().stream().filter(item -> {
                return item.getOpcion() == this.getSelected();
            }).count() == 0) {
                this.repositorio.remove(this.getSelected());
                return "remove";
            } else {
                return "";
            }

        }
        //se tiene que poner el error
        return "";
    }

    @Override
    public String preEdit() {

        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());

        }
        return "sucess";
    }
}
