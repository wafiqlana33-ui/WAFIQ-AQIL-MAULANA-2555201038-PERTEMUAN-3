/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author aqilm
 */
public class Rekening {
    String NoRekening ;
    String NamaPemilik ;
    long Saldo ;
    
    void ceksaldo() {
        System.out.printf("Saldo Anda: Rp%,d%n", Saldo);
    }
    
      public void setor(long jumlahsetor) {
        if (jumlahsetor <= 0) {
            System.out.println("Nominal Harus Lebih Dari Nol !");
        } else {
            Saldo += jumlahsetor;
            System.out.println("Setor Tunai Berhasil");
            ceksaldo();
        }
    }

    public void tarik(long jumlahtarik) {
        if (jumlahtarik <= 0) {
            System.out.println("Nominal Harus Lebih Dari Nol !");
        } else if (jumlahtarik > Saldo) {
            System.out.println("Saldo Anda Tidak Mencukupi");
        } else {
            Saldo -= jumlahtarik;
            System.out.println("Tarik Tunai Berhasil.");
            ceksaldo();
        }
    }  
}

