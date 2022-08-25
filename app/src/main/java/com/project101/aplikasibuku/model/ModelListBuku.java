package com.project101.aplikasibuku.model;

public class ModelListBuku {
    private String judulBuku;
    private String gambarBuku;

    public ModelListBuku(String judulBuku, String gambarBuku) {
        this.judulBuku = judulBuku;
        this.gambarBuku = gambarBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getGambarBuku() {
        return gambarBuku;
    }

    public void setGambarBuku(String gambarBuku) {
        this.gambarBuku = gambarBuku;
    }
}
