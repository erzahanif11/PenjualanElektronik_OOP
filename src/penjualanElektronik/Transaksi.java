package penjualanElektronik;
import java.text.DecimalFormat;

public class Transaksi {
	private String idTransaksi;
    private Pembeli pembeli;
    private BarangElektronik barang;
    private int jumlah;
    private double totalHarga;
    private Pembayaran metodePembayaran;
    private String statusTransaksi;
    DecimalFormat formatRupiah = new DecimalFormat("Rp #,###");

    public Transaksi(String idTransaksi, Pembeli pembeli, BarangElektronik barang, int jumlah, Pembayaran metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.pembeli = pembeli;
        this.barang = barang;
        this.jumlah = jumlah;
        this.metodePembayaran = metodePembayaran;
        this.totalHarga = barang.getHarga() * jumlah;
    }

    public void prosesTransaksi() {
        if (barang.cekStok(jumlah)) {
            barang.kurangiStok(jumlah);
            metodePembayaran.prosesPembayaran(totalHarga);
            statusTransaksi = metodePembayaran.getStatus();
        } else {
        	System.out.println("=============================================================");
        	System.out.println("Pembayaran batal diproses karena stok habis");
            statusTransaksi = "Gagal, Stok tidak mencukupi";
        }
    }

    public void cekDetailTransaksi() {
    	System.out.println("=============================================================");
    	System.out.println("ID Transaksi     : " + idTransaksi);
        pembeli.getInfoPembeli();
        System.out.println("Barang Dibeli    : " + barang.getNamaBarang());
        System.out.println("Jumlah Barang    : " + jumlah);
        System.out.println("Total Harga      : " + formatRupiah.format(totalHarga));
        System.out.println("Metode Pembayaran: " + metodePembayaran.getJenisPembayaran());
        System.out.println("Status Transaksi : " + statusTransaksi);
        System.out.println("=============================================================\n");
    }
    public String cetakDetailTransaksi() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============================================================\n");
        sb.append("ID Transaksi     : ").append(idTransaksi).append("\n");
        sb.append(pembeli.getInfoPembeli()).append("\n");
        sb.append("Barang Dibeli    : ").append(barang.getNamaBarang()).append("\n");
        sb.append("Jumlah Barang    : ").append(jumlah).append("\n");
        sb.append("Total Harga      : ").append(formatRupiah.format(totalHarga)).append("\n");
        sb.append("Metode Pembayaran: ").append(metodePembayaran.getJenisPembayaran()).append("\n");
        sb.append("Status Transaksi : ").append(statusTransaksi).append("\n");
        sb.append("=============================================================\n\n");
        return sb.toString();
    }
}
