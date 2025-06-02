package model;

public class TV extends BarangElektronik {
    private double ukuranLayar;
    private String tipeLayar;
    private String resolusi;

    public TV(String namaBarang, String merk, double harga, int stok, double ukuranLayar, String tipeLayar, String resolusi) {
        super(namaBarang, merk, harga, stok);
        this.ukuranLayar = ukuranLayar;
        this.tipeLayar = tipeLayar;
        this.resolusi = resolusi;
    }

    @Override
    public void showInfo() {
        System.out.println("TV: " + namaBarang + " | Merk: " + merk + " | Harga: Rp " + formatRupiah.format(harga));
        System.out.println("Ukuran: " + ukuranLayar + " inci | Tipe: " + tipeLayar + " | Resolusi: " + resolusi);
        System.out.println("Stok Tersedia: " + stok);
    }
}
