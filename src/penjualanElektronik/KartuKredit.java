package penjualanElektronik;

public class KartuKredit implements Pembayaran{
	private String namaPemegang;
    private String nomorKartu;
    private boolean status;

    public KartuKredit(String namaPemegang, String nomorKartu) {
        this.namaPemegang = namaPemegang;
        this.nomorKartu = nomorKartu;
    }

    @Override
    public String getJenisPembayaran() {
        return "Kartu Kredit dengan Nomor Kartu "+nomorKartu;
    }

    @Override
    public void prosesPembayaran(double harga) {
    	System.out.println("=============================================================");
        System.out.println("Pembayaran dengan kartu kredit atas nama " + namaPemegang+" telah berhasil");
        status = true;
    }

    @Override
    public boolean validasiPembayaran() {
        return status;
    }

    @Override
    public String getStatus() {
        return validasiPembayaran() ? "Pembayaran berhasil" : "Pembayaran gagal";
    }
}
