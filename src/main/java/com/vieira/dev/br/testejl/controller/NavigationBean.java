package com.vieira.dev.br.testejl.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class NavigationBean {

    public String paraDetalhe() {
        return "pesquisar?faces-redirect=true";
    }

    public String todos() {
        return "index?faces-redirect=true";
    }

    public String estoqueBaixo() {
        return "estoque-baixo?faces-redirect=true";
    }

}
