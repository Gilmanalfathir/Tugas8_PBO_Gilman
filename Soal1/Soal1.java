/* Nama program : Tugas 8 UTS No. 1.java
Nama : Gilman Nahdi Al-fathir
NPM : 140810210060
Tanggal buat : 23-10-2022
Deskripsi : pangkat bilangan
******************************************************/

import java.util.Scanner;
class Pangkat{
    private int angka;
    private int pangkat;
    
    Pangkat(){
        this.angka = 0 ;
        this.pangkat = 0 ;
    }
    
    Pangkat(int angka, int pangkat){
        this.angka = angka;
        this.pangkat = pangkat;
    }

    public void setAngka(int angka){
        this.angka = angka;

    }

    public int getAngka(){
        return this.angka;
    }

    public void setPangkat(int pangkat){
        this.pangkat = pangkat;

    }

    public int getPangkat(){
        return this.pangkat;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Angka : ");
        setAngka(sc.nextInt());
        System.out.print("Masukkan Pangkat : ");
        setPangkat(sc.nextInt());
        sc.close();
    }

    public void output(){
        System.out.println("Hasil pangkat dari " + getAngka() + " pangkat " + getPangkat() + " = " + hasilPangkat());
    }

    int hasilPangkat(){
        int hasil = 1;
        for(int i = 1; i <= getPangkat(); i++){
            hasil *= getAngka();
        }
    return hasil;
    }
}

public class Soal1 {
    public static void main(String[] args) {
        Pangkat data = new Pangkat();
        data.input();
        data.output();
    }
}