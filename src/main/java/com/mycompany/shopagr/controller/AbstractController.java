/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopagr.controller;


import com.mycompany.shopagr.controller.repository.IRepository;
import com.mycompany.shopagr.controller.repository.MemoryRepository;
import com.mycompany.shopagr.controller.IController;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.List;
import java.util.function.Supplier;
import org.primefaces.util.Lazy;

/**
 *
 * @author Adr1
 * @param <T>
 */
public abstract class AbstractController<T> implements IController<T> {

    protected IRepository<T> repositorio;

    private Supplier<T> contructor;
    private T current;

    public AbstractController(Supplier<T> s) {
        this.repositorio = new MemoryRepository<T>();
        this.contructor = s;

    }

    @Override
    public T getSelected() {
        return this.current;
    }

    @Override
    public String cancel() {
        //this.current=null;
        return "sucess";
    }

    @Override
    public List<T> getItems() {
        List<T> t = this.repositorio.getAll();
        return t;
    }

    @Override
    public void setSelected(T element) {
        this.current = element;
    }

    @Override
    public String create() {
        this.current = this.contructor.get();
        return "create";
    }

}
