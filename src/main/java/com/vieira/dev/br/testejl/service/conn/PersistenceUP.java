/*
 */
package com.vieira.dev.br.testejl.service.conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

/**
 *
 * @author francisco
 */
public class PersistenceUP {

    private static EntityManagerFactory fact;

    public static EntityManager createEntityManager() {
        if (Objects.isNull(fact)) {
            fact = Persistence.createEntityManagerFactory("persistenceUP");
        }
        return fact.createEntityManager();
    }

}
