package penjualanElektronik;

public class TransferBank implements Pembayaran{
	private String namaBank;
    private String nomorRekening;
    private boolean status;

    public TransferBank(String namaBank, String nomorRekening) {
        this.namaBank = namaBank;
        this.nomorRekening = nomorRekening;
    }

    @Override
    public String getJenisPembayaran() {
        return "Transfer Bank dengan Nomor Rekening "+nomorRekening;
    }

    @Override
    public void prosesPembayaran(double harga) {
    	System.out.println("=============================================================");
    	System.out.println("Pembayaran dengan transfer bank melalui " + namaBank + " telah berhasil");
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
