package penjualanElektronik;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatRupiah = new DecimalFormat("Rp #,###");
        Scanner input = new Scanner(System.in);
        boolean running = true;

        DataCollection.daftarBarang.add(new Laptop("Asus ROG", "Asus", 20000000, 5, "Intel i7", "NVIDIA RTX 3060", 16));
        DataCollection.daftarBarang.add(new Handphone("iPhone 15", "Apple", 18000000, 10, 4500, 48, true));
        DataCollection.daftarBarang.add(new TV("Samsung Smart TV", "Samsung", 15000000, 4, 55.0, "LED", "4K UHD"));

        while (running) {
        	System.out.println("\n=== SISTEM PENJUALAN ELEKTRONIK ===");
            System.out.println("Menu:");
            System.out.println("1. Lihat Daftar Barang");
            System.out.println("2. Beli Barang");
            System.out.println("3. Lihat Riwayat Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int menu = input.nextInt();
            input.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.println("\n== Daftar Barang ==");
                    for (int i = 0; i < DataCollection.daftarBarang.size(); i++) {
                        BarangElektronik b = DataCollection.daftarBarang.get(i);
                        System.out.println((i + 1) + ". " + b.getNamaBarang() + " (" + b.getMerk() + ") - Rp" + formatRupiah.format(b.getHarga()) + " - Stok: " + b.getStok());
                    }
                    break;

                case 2:
                    System.out.println("\n== Pembelian Barang ==");
                    System.out.print("Masukkan nama pembeli: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan alamat pembeli: ");
                    String alamat = input.nextLine();
                    System.out.print("Masukkan nomor HP pembeli: ");
                    String noHp = input.nextLine();
                    Pembeli pembeli = new Pembeli(nama, alamat, noHp);
                    for (int i = 0; i < DataCollection.daftarBarang.size(); i++) {
                        BarangElektronik b = DataCollection.daftarBarang.get(i);
                        System.out.println((i + 1) + ". " + b.getNamaBarang() + " (" + b.getMerk() + ") - Rp" + formatRupiah.format(b.getHarga()) + " - Stok: " + b.getStok());
                    }

                    System.out.print("Pilih nomor barang: ");
                    int pilihBarang = input.nextInt() - 1;
                    BarangElektronik barang = DataCollection.daftarBarang.get(pilihBarang);

                    System.out.print("Masukkan jumlah beli: ");
                    int jumlah = input.nextInt();
                    input.nextLine(); 

                    if (jumlah > barang.getStok()) {
                        System.out.println("Stok tidak cukup!");
                        break;
                    }

                    System.out.println("Metode pembayaran");
                    System.out.println("1. Kartu Kredit");
                    System.out.println("2. Transfer Bank");
                    System.out.print("Pilih metode pembayaran: ");
                    int metode = input.nextInt();
                    input.nextLine();
                    Pembayaran pembayaran;

                    if (metode == 1) {
                        System.out.print("Nama pemilik kartu: ");
                        String namaKartu = input.nextLine();
                        System.out.print("Nomor kartu: ");
                        String noKartu = input.nextLine();
                        pembayaran = new KartuKredit(namaKartu, noKartu);
                    } else {
                        System.out.print("Nama bank: ");
                        String namaBank = input.nextLine();
                        System.out.print("Nomor rekening: ");
                        String noRek = input.nextLine();
                        pembayaran = new TransferBank(namaBank, noRek);
                    }

                    String idTransaksi = "TRX" + (FileOperation.hitungTransaksiDalamFile() + 1);
                    Transaksi transaksi = new Transaksi(idTransaksi, pembeli, barang, jumlah, pembayaran);
                    transaksi.prosesTransaksi();
                    transaksi.cekDetailTransaksi();
                    FileOperation.writeToFile(transaksi.cetakDetailTransaksi());

                    break;

                case 3:
                    System.out.println("\n== Riwayat Transaksi ==");
                    FileOperation.readFromFile();
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem penjualan!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}


