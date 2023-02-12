/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopagr.controller;

import com.mycompany.shopagr.model.Categoria;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author Adr1
 */
@Named
@ApplicationScoped
public class CategoriaController extends AbstractController<Categoria> {
    @Inject
    TiendaController tiendacontroller;
    public CategoriaController() {
        super(Categoria::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Perfumes");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Verduras");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Carnes");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            if (this.tiendacontroller.getItems().stream().filter(item -> {
                return item.getCategoria()== this.getSelected();
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
            //si ya existe
    
        }
        return "sucess";
    }
}