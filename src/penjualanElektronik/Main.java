package penjualanElektronik;

import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatRupiah = new DecimalFormat("#,###");
        Scanner input = new Scanner(System.in);
        boolean running = true;

        DataCollection.daftarBarang.add(new Laptop("Asus ROG", "Asus", 20000000, 5, "Intel i7", "NVIDIA RTX 3060", 16));
        DataCollection.daftarBarang.add(new Handphone("iPhone 15", "Apple", 18000000, 10, 4500, 48, true));
        DataCollection.daftarBarang.add(new TV("Samsung Smart TV", "Samsung", 15000000, 4, 55.0, "LED", "4K UHD"));

        while (running) {
            try {
                System.out.println("\n=== SISTEM PENJUALAN ELEKTRONIK ===");
                System.out.println("Menu:");
                System.out.println("1. Lihat Daftar Barang");
                System.out.println("2. Beli Barang");
                System.out.println("3. Lihat Riwayat Transaksi");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1-4): ");
                int menu = Integer.parseInt(input.nextLine());

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
                        Pembeli pembeli;
                        try {
                            System.out.print("Masukkan nama pembeli: ");
                            String nama = input.nextLine();
                            System.out.print("Masukkan alamat pembeli: ");
                            String alamat = input.nextLine();
                            System.out.print("Masukkan nomor HP pembeli: ");
                            String noHp = input.nextLine();
                            pembeli = new Pembeli(nama, alamat, noHp);
                        } catch (FormatTidakValidException e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
                        }

                        for (int i = 0; i < DataCollection.daftarBarang.size(); i++) {
                            BarangElektronik b = DataCollection.daftarBarang.get(i);
                            System.out.println((i + 1) + ". " + b.getNamaBarang() + " (" + b.getMerk() + ") - Rp" + formatRupiah.format(b.getHarga()) + " - Stok: " + b.getStok());
                        }

                        System.out.print("Pilih nomor barang: ");
                        int pilihBarang = Integer.parseInt(input.nextLine()) - 1;
                        if (pilihBarang < 0 || pilihBarang >= DataCollection.daftarBarang.size()) {
                            System.out.println("Pilihan barang tidak valid!");
                            break;
                        }
                        BarangElektronik barang = DataCollection.daftarBarang.get(pilihBarang);

                        System.out.print("Masukkan jumlah beli: ");
                        int jumlah = Integer.parseInt(input.nextLine());
                        if (jumlah <= 0) {
                            System.out.println("Jumlah beli harus lebih dari 0!");
                            break;
                        }
                        if (jumlah > barang.getStok()) {
                            System.out.println("Stok tidak cukup!");
                            break;
                        }

                        System.out.println("Metode pembayaran");
                        System.out.println("1. Kartu Kredit");
                        System.out.println("2. Transfer Bank");
                        System.out.print("Pilih metode pembayaran: ");
                        int metode = Integer.parseInt(input.nextLine());

                        Pembayaran pembayaran;
                        try {
                            if (metode == 1) {
                                System.out.print("Nama pemilik kartu: ");
                                String namaKartu = input.nextLine();
                                System.out.print("Nomor kartu: ");
                                String noKartu = input.nextLine();
                                pembayaran = new KartuKredit(namaKartu, noKartu);
                            } else if (metode == 2) {
                                System.out.print("Nama bank: ");
                                String namaBank = input.nextLine();
                                System.out.print("Nomor rekening: ");
                                String noRek = input.nextLine();
                                pembayaran = new TransferBank(namaBank, noRek);
                            } else {
                                System.out.println("Metode pembayaran tidak valid!");
                                break;
                            }
                        } catch (FormatTidakValidException e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
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
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}