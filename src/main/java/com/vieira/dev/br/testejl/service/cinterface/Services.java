/*
 */
package com.vieira.dev.br.testejl.service.cinterface;

import com.vieira.dev.br.testejl.model.cinterface.EntityModel;

import java.util.List;

/**
 *
 * @author francisco
 * @param <T>
 */
public interface Services<T extends EntityModel> {

    T findById(Long id);

    List<T> findAll();

    T salvar(T t);

    boolean delete(T t);

}
