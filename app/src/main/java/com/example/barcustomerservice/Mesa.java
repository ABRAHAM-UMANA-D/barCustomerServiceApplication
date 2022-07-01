package com.example.barcustomerservice;

public class Mesa {
    private String key;
    private int numero_mesa;

    public Mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

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
