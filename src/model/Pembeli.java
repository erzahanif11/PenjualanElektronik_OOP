package model;

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
        sb.append("Nama Pembeli     : ").append(namaPembeli).append("\n");
        sb.append("Alamat           : ").append(alamat).append("\n");
        sb.append("Nomor Telepon    : ").append(nomorTelepon).append("\n");
        return sb.toString();
    }
}
