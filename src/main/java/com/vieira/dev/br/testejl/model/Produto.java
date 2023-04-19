package com.vieira.dev.br.testejl.model;

import com.vieira.dev.br.testejl.model.cinterface.EntityModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "TBL_PRODUTO")
public class Produto implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Integer estoque;
    @Column(name = "quantidade_minima")
    private Integer quantidadeMinima;
    private BigDecimal valor;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Produto(Long id, String descricao, Integer quantidadeMinima, Integer estoque, BigDecimal valor, Date dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
        this.estoque = estoque;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isEstoqueBaixo(){
        return Objects.nonNull(quantidadeMinima)  && estoque < quantidadeMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
