package com.andreick.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonalData personalData = new PersonalData();

    public Client() {
    }

    public Client(String name, String cpf) {
        personalData = new PersonalData(name, cpf);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return personalData.getName();
    }

    public String getCpf() {
        return personalData.getCpf();
    }
}
