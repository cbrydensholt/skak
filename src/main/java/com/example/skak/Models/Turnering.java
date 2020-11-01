package com.example.skak.Models;

public class Turnering {

    int turneringsId;
    String turneringsNavn;
    int antalDeltagere;
    String dato;
    String deltagerKategori;


    public Turnering(int turneringsId, String turneringsNavn, int antalDeltagere, String dato, String deltagerKategori) {
        this.turneringsId = turneringsId;
        this.turneringsNavn = turneringsNavn;
        this.antalDeltagere = antalDeltagere;
        this.dato = dato;
        this.deltagerKategori = deltagerKategori;
    }

    public Turnering() {

    }

    public int getTurneringsId() {
        return turneringsId;
    }

    public void setTurneringsId(int turneringsId) {
        this.turneringsId = turneringsId;
    }

    public String getTurneringsNavn() {
        return turneringsNavn;
    }

    public void setTurneringsNavn(String turneringsNavn) {
        this.turneringsNavn = turneringsNavn;
    }

    public int getAntalDeltagere() {
        return antalDeltagere;
    }

    public void setAntalDeltagere(int antalDeltagere) {
        this.antalDeltagere = antalDeltagere;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getDeltagerKategori() {
        return deltagerKategori;
    }

    public void setDeltagerKategori(String deltagerKategori) {
        this.deltagerKategori = deltagerKategori;
    }
}
