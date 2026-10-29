/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author aqilm
 */
import java.util.ArrayList;
import java.util.Scanner;

    public class SistemATM {
    
        static class nasabahatm {
        Nasabah nasabah;
        Rekening rekening;  
    
        nasabahatm(Nasabah nasabah, Rekening rekening){
            this.nasabah = nasabah;
            this.rekening = rekening;
       }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<nasabahatm> daftarNasabah = new ArrayList<>();
        
        //nasabah 1
        Nasabah nasabah1 = new Nasabah();
       nasabah1.nama = "Baba";
       nasabah1.alamat = "Blitar";
       nasabah1.noidentitas  = "12345";
       nasabah1.pin  ="112233";
       
       Rekening rekening1 = new Rekening();
       rekening1.NoRekening = "255538";
       rekening1.NamaPemilik  = nasabah1.nama;
       rekening1.Saldo = 7000000;
       
       daftarNasabah.add(new nasabahatm(nasabah1, rekening1));
       
       //nasaba 2
       Nasabah nasabah2 = new Nasabah();
       nasabah2.nama = "Bobo";
       nasabah2.alamat = "Blitar";
       nasabah2.noidentitas  = "12345";
       nasabah2.pin  ="2006";
       
       Rekening rekening2 = new Rekening();
       rekening2.NoRekening = "255538";
       rekening2.NamaPemilik = nasabah2.nama;
       rekening2.Saldo = 5000000;
       
       daftarNasabah.add(new nasabahatm(nasabah2, rekening2));
       
       
       ATM atm = new ATM();
      atm.id = "BRI";
      atm.lokasi = "Blitar";
      atm.status = "Online";
      
      nasabahatm penggunaaktif = null;
      int percobaan = 0;
         System.out.println("=== LOGIN ATM ===");
         
         while (percobaan < 4) {
             System.out.println("Masukan Pin:  ");
             String pin = input.nextLine();
             
             for (nasabahatm pengguna : daftarNasabah) {
                if (pin.equals(pengguna.nasabah.pin)) {
                    penggunaaktif = pengguna;
                    break;
             }
         }
             if (penggunaaktif != null) {
                break;
            }
             
         percobaan++;
            System.out.println("PIN salah!");
            System.out.println("Sisa percobaan: " + (4 - percobaan));
        }
    
         if (penggunaaktif == null) {
            System.out.println("Login gagal ! Atm Terblokir!");
            input.close();
            return;
        }
         
         System.out.println(
            "Selamat datang, " + penggunaaktif.nasabah.nama
        );
         
          int menu = 0;

        while (menu != 5) {
            System.out.println("\n=== MENU ATM ===");
            System.out.println("1. Data Nasabah");
            System.out.println("2. Cek Saldo");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                menu = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan Tidak valid!");
                continue;
            }

            switch (menu) {
                case 1:
                    penggunaaktif.nasabah.tampilkandata();
                    break;

                case 2:
                    atm.ceksaldo(penggunaaktif.rekening);
                    break;

                case 3:
                    System.out.print("Nominal setor: Rp");
                    try {
                        long setor = Long.parseLong(input.nextLine());
                        atm.setor(penggunaaktif.rekening, setor);
                    } catch (NumberFormatException e) {
                        System.out.println("Nominal tidak valid.");
                    }
                    break;

                case 4:
                    System.out.print("Nominal tarik: Rp");
                    try {
                        long tarik = Long.parseLong(input.nextLine());
                        atm.tarik(penggunaaktif.rekening, tarik);
                    } catch (NumberFormatException e) {
                        System.out.println("Nominal tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

        input.close();      
    }
}


