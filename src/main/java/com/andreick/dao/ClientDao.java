package com.andreick.dao;

import com.andreick.model.Client;

import javax.persistence.EntityManager;

public class ClientDao {

    private EntityManager em;

    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public void register(Client client) {
        em.persist(client);
    }

    public Client findById(long id) {
        return em.find(Client.class, id);
    }
}
