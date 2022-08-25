package com.project101.aplikasibuku.model;

public class ModelBukuPopuler {
    private String buku;
    private String gambar;
    private String deskripsi;
    private int numberInCart;
    private double harga;

    public ModelBukuPopuler(String buku, String gambar, String deskripsi, double harga) {
        this.buku = buku;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public ModelBukuPopuler(String buku, String gambar, String deskripsi, int numberInCart, double harga) {
        this.buku = buku;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.numberInCart = numberInCart;
        this.harga = harga;
    }

    public String getBuku() {
        return buku;
    }

    public void setBuku(String buku) {
        this.buku = buku;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
