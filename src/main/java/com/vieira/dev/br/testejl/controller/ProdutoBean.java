package com.vieira.dev.br.testejl.controller;


import com.google.common.base.Strings;
import com.vieira.dev.br.testejl.model.Produto;
import com.vieira.dev.br.testejl.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

    @Inject
    transient private Produto produto;

    @Inject
    transient   private ProdutoService service;

    private String pesquisa;

    private boolean estoque;

    private List<Produto> produtos;

    @PostConstruct
    public void init() {
        this.produtos = this.service.findAll();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<Produto> getProdutos() {
        if (estoque) {
            return produtos.stream().filter(Produto::isEstoqueBaixo).collect(Collectors.toList());
        }
        return produtos;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void estoqueEvent(ValueChangeEvent event) {
        estoque = Boolean.parseBoolean(String.valueOf(event.getNewValue()));
    }

    public boolean pesquisar() {
        if (!Strings.isNullOrEmpty(pesquisa))
            this.produto = this.service.findByDescricao((pesquisa))
                    .stream()
                    .findFirst()
                    .orElse(new Produto());
        return Objects.nonNull(this.produto.getId());
    }

    public String getEstoqueBaixo() {
        return Objects.isNull(produto) || produto.isEstoqueBaixo() ? "Estoque abaixo do mínimo" : "Estoque controlado";
    }
}
