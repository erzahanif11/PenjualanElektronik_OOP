package model;

import java.text.DecimalFormat;

public abstract class BarangElektronik {
    DecimalFormat formatRupiah = new DecimalFormat("Rp #,###");
    protected String namaBarang;
    protected String merk;
    protected double harga;
    protected int stok;

    public BarangElektronik(String namaBarang, String merk, double harga, int stok) {
        this.namaBarang = namaBarang;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;
    }

    public abstract void showInfo();

    public boolean cekStok(int jumlah) {
        return stok >= jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (cekStok(jumlah)) {
            stok -= jumlah;
        }
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getMerk() {
        return merk;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }
}
