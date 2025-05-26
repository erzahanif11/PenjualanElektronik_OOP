package penjualanElektronik;

public class Pembeli {
	private String namaPembeli;
    private String alamat;
    private String nomorTelepon;

    public Pembeli(String namaPembeli, String alamat, String nomorTelepon) {
        this.namaPembeli = namaPembeli;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }
    
    public String getInfoPembeli() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Nama Pembeli     : " + namaPembeli + "\n");
    	sb.append("Alamat	         : " + alamat + "\n");
    	sb.append("Nomor Telepon    : " + nomorTelepon);
    	return sb.toString();
    }
}
