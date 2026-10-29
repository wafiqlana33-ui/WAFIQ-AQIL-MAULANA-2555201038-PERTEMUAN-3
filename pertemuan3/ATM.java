/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author aqilm
 */
public class ATM {
    String id;
    String lokasi;
    String status;
    
        void ceksaldo(Rekening rekening){
            rekening.ceksaldo();
        }
        void tarik(Rekening rekening, long jumlahtarik){
            rekening.tarik(jumlahtarik);
        }
        void setor(Rekening rekening, long jumlahsetor){
            rekening.setor(jumlahsetor);
        }
}
    

