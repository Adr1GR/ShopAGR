/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopagr.controller;

import com.mycompany.shopagr.model.Categoria;
import com.mycompany.shopagr.model.Promocion;
import com.mycompany.shopagr.model.Opcion;
import com.mycompany.shopagr.model.Tienda;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 *
 * @author Adr1
 */
@Named
@ApplicationScoped
public class TiendaController extends AbstractController<Tienda> {

    @Inject
    private PromocionController promocionController;
    @Inject
    private CategoriaController categoriaController;
    @Inject
    private OpcionController opcionController;

    public TiendaController() {
        super(Tienda::new);
        //this.load();
    }

    @Override
    public Tienda getSelected() {
        return super.getSelected();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Mercadona");
        this.getSelected().setDireccion("Calle Levante");
        this.getSelected().setDescripcion("descripcion larga");
        this.getSelected().setCoordenadas("38.090379794941676, -0.7200492760853432");
        
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Consum");
         this.getSelected().setDireccion("Calle maria del sol");
        this.getSelected().setDescripcion("Descripcion");
        this.getSelected().setCoordenadas("38.090379794941676, -0.7200492760853432");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            this.repositorio.remove(this.getSelected());
            return "remove";
        } else {
            return "";
        }

    }

    @Override
    public String preEdit() {
        return "edit";
    }

    public void selectedChange(ValueChangeEvent event) {
        this.setSelected((Tienda) event.getNewValue());
    }

    public Tienda getTiendaById(int id) {
        Tienda p = null;
        Optional<Tienda> element = this.getItems().stream().filter(item -> {
            return item.getId() == id;
        }).findFirst();
        if (!element.isEmpty()) {
            p = element.get();
        }
        return p;
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected() != null) {
            if (this.getSelected().getId() == -1) {
                this.getSelected().setId(this.repositorio.getAll().size() + 1);
                this.repositorio.create(this.getSelected());
            } else {

                this.repositorio.update(this.getSelected());
            }
        }
        return "sucess";
    }
}
