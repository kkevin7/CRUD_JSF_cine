package com.study.primefaces.controller;

import com.study.primefaces.entities.Categoria;
import com.study.primefaces.model.CategoriaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@Named(value = "categoriaController")
@ViewScoped
public class CategoriaController implements Serializable {

//    Entrar a http://localhost:8080/pelicula/pages/categoria.jsf
    public CategoriaController() {
    }

    @Inject
    private CategoriaFacadeLocal categoriaFL;
    private Categoria categoria = new Categoria();
    private Categoria selectCategoria = new Categoria();
    private List<Categoria> listaCategoria;
    boolean btnCreate = true;
    boolean btnEdit = false;
    boolean btnDelete = false;

    @PostConstruct
    public void init() {
    }

    @Deprecated
    public List<Categoria> obtenerTodos() {
        List<Categoria> salida = new ArrayList();
        try {
            if (categoriaFL != null) {
                salida = categoriaFL.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    public void onRowSelect(SelectEvent event) {
        this.categoria = this.selectCategoria;
        btnCreate = false;
        btnEdit = true;
        btnDelete = true;
    }

    public void crear() {
        try {
            if (this.categoria != null && this.categoriaFL != null) {
                if (this.categoriaFL.create(this.categoria) == true) {
                    this.limpiar();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Creado con Exito!", null));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo crear el registro!", null));
                }
            } else {
                System.err.println("La entity esta vacia revisar");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void limpiar(){
        try {
            this.categoria = new Categoria();
            this.selectCategoria = new Categoria();
            btnCreate = true;
            btnEdit = false;
            btnDelete = false;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void update(){
        try {
            if (this.categoria != null && this.categoriaFL != null) {
                if (this.categoriaFL.edit(this.categoria) == true) {
                    this.limpiar();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Moficiado con Exito!", null));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo modificar el registro!", null));
                }
            } else {
                System.err.println("La entity esta vacia revisar");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void delete(){
        try {
            if (this.categoria != null && this.categoriaFL != null) {
                if (this.categoriaFL.remove(this.categoria) == true) {
                    this.limpiar();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado con Exito!", null));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo eliminar el registro!", null));
                }
            } else {
                System.err.println("La entity esta vacia revisar");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Categoria getSelectCategoria() {
        return selectCategoria;
    }

    public void setSelectCategoria(Categoria selectCategoria) {
        this.selectCategoria = selectCategoria;
    }

    public boolean isBtnCreate() {
        return btnCreate;
    }

    public void setBtnCreate(boolean btnCreate) {
        this.btnCreate = btnCreate;
    }

    public boolean isBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(boolean btnEdit) {
        this.btnEdit = btnEdit;
    }

    public boolean isBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(boolean btnDelete) {
        this.btnDelete = btnDelete;
    }
    
    

}
