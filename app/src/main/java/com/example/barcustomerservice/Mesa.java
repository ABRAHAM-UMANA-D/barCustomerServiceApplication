package com.example.barcustomerservice;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Mesa implements Serializable {
    @Exclude
    private String key;
    private int numero_mesa;

    public Mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public Mesa() {}

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
}
