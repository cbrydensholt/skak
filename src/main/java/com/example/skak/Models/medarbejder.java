package com.example.skak.Models;

public class medarbejder {

    int arbejderId;
    String arbejderFornavn;
    String arbejderEfternavn;
    int arbejderTelefon;
    String arbejderTitel;


    public medarbejder(int arbejderId, String arbejderFornavn, String arbejderEfternavn, int arbejderTelefon, String arbejderTitel) {
        this.arbejderId = arbejderId;
        this.arbejderFornavn = arbejderFornavn;
        this.arbejderEfternavn = arbejderEfternavn;
        this.arbejderTelefon = arbejderTelefon;
        this.arbejderTitel = arbejderTitel;
    }

    public medarbejder() {

    }


    public int getArbejderId() {
        return arbejderId;
    }

    public void setArbejderId(int arbejderId) {
        this.arbejderId = arbejderId;
    }

    public String getArbejderFornavn() {
        return arbejderFornavn;
    }

    public void setArbejderFornavn(String arbejderFornavn) {
        this.arbejderFornavn = arbejderFornavn;
    }

    public String getArbejderEfternavn() {
        return arbejderEfternavn;
    }

    public void setArbejderEfternavn(String arbejderEfternavn) {
        this.arbejderEfternavn = arbejderEfternavn;
    }

    public int getArbejderTelefon() {
        return arbejderTelefon;
    }

    public void setArbejderTelefon(int arbejderTelefon) {
        this.arbejderTelefon = arbejderTelefon;
    }

    public String getArbejderTitel() {
        return arbejderTitel;
    }

    public void setArbejderTitel(String arbejderTitel) {
        this.arbejderTitel = arbejderTitel;
    }

    @Override
    public String toString() {
        return "medarbejder{" +
                "arbejderId=" + arbejderId +
                ", arbejderFornavn='" + arbejderFornavn + '\'' +
                ", arbejderEfternavn='" + arbejderEfternavn + '\'' +
                ", arbejderTelefon=" + arbejderTelefon +
                ", arbejderTitel='" + arbejderTitel + '\'' +
                '}';
    }
}
