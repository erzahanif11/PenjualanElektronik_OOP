package penjualanElektronik;

public class Handphone extends BarangElektronik{
	private int kapasitasBaterai;
    private int kameraMP;
    private boolean dualSIM;

    public Handphone(String namaBarang, String merk, double harga, int stok, int kapasitasBaterai, int kameraMP, boolean dualSIM) {
        super(namaBarang, merk, harga, stok);
        this.kapasitasBaterai = kapasitasBaterai;
        this.kameraMP = kameraMP;
        this.dualSIM = dualSIM;
    }

    @Override
    public void showInfo() {
        System.out.println("Handphone: " + namaBarang + " | Merk: " + merk + " | Harga: Rp " + formatRupiah.format(harga));
        System.out.println("Baterai: " + kapasitasBaterai + "mAh | Kamera: " + kameraMP + "MP | Dual SIM: " + dualSIM);
        System.out.println("Stok Tersedia: "+stok);
    }
}
