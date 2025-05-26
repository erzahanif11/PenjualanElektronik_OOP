package penjualanElektronik;
import java.util.*;
import java.io.*;

public class FileOperation {
   public static void writeToFile(String s) {
       String path = "riwayat_transaksi.txt";
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
           writer.write(s);
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
   }


   public static void readFromFile() {
       String path = "riwayat_transaksi.txt";
       try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
           String line;
           System.out.println("Riwayat Transaksi:");
           while ((line = reader.readLine()) != null) {
               System.out.println(line);
           }
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
   }
   
   public static int hitungTransaksiDalamFile() {
	    int jumlah = 0;
	    try (Scanner fileScanner = new Scanner(new File("riwayat_transaksi.txt"))) {
	        while (fileScanner.hasNextLine()) {
	            String baris = fileScanner.nextLine();
	            if (baris.startsWith("ID Transaksi")) {
	                jumlah++;
	            }
	        }
	    } catch (FileNotFoundException e) {
	        return 0;
	    }
	    return jumlah;
	}
}

