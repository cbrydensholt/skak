package com.example.skak.Models;

public class medlem {

    int medlemsId;
    String medlemsFornavn;
    String medlemsEfternavn;
    int medlemsTelefon;
    String medlemsKategori;
    int medlemsRating;
    int medlemsRestance;


    public medlem(int medlemsId, String medlemsFornavn, String medlemsEfternavn, int medlemsTelefon, String medlemsKategori, int medlemsRating, int medlemsRestance) {
        this.medlemsId = medlemsId;
        this.medlemsFornavn = medlemsFornavn;
        this.medlemsEfternavn = medlemsEfternavn;
        this.medlemsTelefon = medlemsTelefon;
        this.medlemsKategori = medlemsKategori;
        this.medlemsRating = medlemsRating;
        this.medlemsRestance = medlemsRestance;
    }

    public medlem() {

    }

    public int getMedlemsId() {
        return medlemsId;
    }

    public void setMedlemsId(int medlemsId) {
        this.medlemsId = medlemsId;
    }

    public String getMedlemsFornavn() {
        return medlemsFornavn;
    }

    public void setMedlemsFornavn(String medlemsFornavn) {
        this.medlemsFornavn = medlemsFornavn;
    }

    public String getMedlemsEfternavn() {
        return medlemsEfternavn;
    }

    public void setMedlemsEfternavn(String medlemsEfternavn) {
        this.medlemsEfternavn = medlemsEfternavn;
    }

    public int getMedlemsTelefon() {
        return medlemsTelefon;
    }

    public void setMedlemsTelefon(int medlemsTelefon) {
        this.medlemsTelefon = medlemsTelefon;
    }

    public String getMedlemsKategori() {
        return medlemsKategori;
    }

    public void setMedlemsKategori(String medlemsKategori) {
        this.medlemsKategori = medlemsKategori;
    }

    public int getMedlemsRating() {
        return medlemsRating;
    }

    public void setMedlemsRating(int medlemsRating) {
        this.medlemsRating = medlemsRating;
    }

    public int getMedlemsRestance() {
        return medlemsRestance;
    }

    public void setMedlemsRestance(int medlemsRestance) {
        this.medlemsRestance = medlemsRestance;
    }
}
