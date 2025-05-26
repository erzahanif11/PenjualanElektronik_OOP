package penjualanElektronik;

public interface Pembayaran {
	String getJenisPembayaran();

    void prosesPembayaran(double harga);

    boolean validasiPembayaran();

    String getStatus();
}
