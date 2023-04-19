package com.vieira.dev.br.testejl.service;

import com.vieira.dev.br.testejl.model.Produto;
import com.vieira.dev.br.testejl.service.cinterface.Services;
import com.vieira.dev.br.testejl.service.conn.PersistenceUP;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoService implements Services<Produto> {


    private final EntityManager manager;

    public ProdutoService() {
        manager = PersistenceUP.createEntityManager();
    }

    @Override
    public Produto findById(Long id) {
        return this.manager.find(Produto.class, id);
    }

    @Override
    public List<Produto> findAll() {
        return this.manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Override
    public Produto salvar(Produto produto) {
        return null;
    }

    @Override
    public boolean delete(Produto produto) {
        return false;
    }
}
