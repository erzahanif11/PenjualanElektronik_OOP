package model;

public class Laptop extends BarangElektronik {
    private String processor;
    private String graphicsCard;
    private int ram;

    public Laptop(String namaBarang, String merk, double harga, int stok, String processor, String graphicsCard, int ram) {
        super(namaBarang, merk, harga, stok);
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.ram = ram;
    }

    @Override
    public void showInfo() {
        System.out.println("Laptop: " + namaBarang + " | Merk: " + merk + " | Harga: Rp " + formatRupiah.format(harga));
        System.out.println("Processor: " + processor + " | Graphics Card: " + graphicsCard + " | RAM: " + ram + "GB");
        System.out.println("Stok Tersedia: " + stok);
    }
}
