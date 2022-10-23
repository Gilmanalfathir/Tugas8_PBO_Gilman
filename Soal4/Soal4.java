/* Nama program : Tugas 8 UTS No. 4.java
Nama : Gilman Nahdi Al-fathir
NPM : 140810210060
Tanggal buat : 23-10-2022
Deskripsi : parkir
******************************************************/
import java.util.Scanner;

class Waktu{
    private int jam;
    private int menit;
    private int detik;

    Waktu(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;

    }
    Waktu(){
        this.jam = 0;
        this.menit = 0;
        this.detik = 0;
    }

    public void setJam(int jam){
        this.jam = jam;
    }

    public int getJam(){
        return this.jam;
    }

    public void setMenit(int menit){
        this.menit = menit;
    }

    public int getMenit(){
        return this.menit;
    }

    public void setDetik(int detik){
        this.detik = detik;
    }
    
    public int getDetik(){
        return this.detik;
    }

    public void inputJam(){
        Scanner sc = new Scanner(System.in);
        System.out.print(" Masukkan jam   : ");
        this.jam = sc.nextInt();
        System.out.print(" Masukkan menit : ");
        this.menit = sc.nextInt();
        System.out.print(" Masukkan detik : ");
        this.detik = sc.nextInt();
    }

    public String getWaktu(){
        String nJam = "";
        String nMenit = "";
        String nDetik = "";
        if(this.jam < 10){
            nJam = "0";
        }
        if(this.menit < 10){
            nMenit = "0";
        }
        if(this.detik < 10){
            nDetik = "0";
        }
        
        return nJam + this.jam + ":" + nMenit + this.menit + ":" + nDetik + this.detik;
    }

    public int totalDetik(){
        int hasil = (this.jam*3600) + (this.menit*60) + (this.detik);
        return hasil;
    }

    public void waktuTotal(int dtk){
        this.menit = dtk / 60;
        this.detik = dtk % 60;
        this.jam = this.menit / 60;
        this.menit = this.menit % 60;
    }

    public Waktu cariDurasi(Waktu akhir){
        Waktu temp =  new Waktu();
        int detikAwal = this.totalDetik();
        int detikAkhir = akhir.totalDetik();
        if(detikAkhir < detikAwal){
            detikAkhir += 86400;
        }
        int detikHasil = detikAkhir - detikAwal;
        temp.waktuTotal(detikHasil);

        return temp;
    }
}

class Parkir{
    private String no;
    private String jenis;
    private Waktu masuk = new Waktu();
    private Waktu keluar = new Waktu();

    Parkir(){
        this.no = "";
        this.jenis = "";
    }
    Parkir(String no, String jenis) {
        this.no = no;
        this.jenis = jenis;
    }

    public void setNoKendaraan(String no){
        this.no = no;
    }
    public String getNoKendaraan(){
        return this.no;
    }
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    public String getJenis(){
        return this.jenis;
    }
    public void setWaktumasuk(Waktu masuk){
        this.masuk = masuk;
    }
    public Waktu getWaktumasuk(){
        return this.masuk;
    }
    public void setWaktukeluar(Waktu keluar){
        this.keluar = keluar;
    }
    public Waktu getWaktukeluar(){
        return this.keluar;
    }

    public void inputKendaraan(){
        Scanner sc = new Scanner(System.in);
        System.out.print("No Kendaraan : ");
        this.no = sc.nextLine();
        System.out.print("Jenis Kendaraan (Mobil/Motor): ");
        this.jenis = sc.nextLine();
        System.out.println("Jam Masuk : ");
        this.masuk.inputJam();
        System.out.println("Jam Keluar : ");
        keluar.inputJam();
    }

    public Waktu getLamaParkir(){
        return this.masuk.cariDurasi(this.keluar);
    }

    public int getJamParkir(){
        int hasil = 0;
        if(this.getLamaParkir().getMenit() >= 10 || this.getLamaParkir().getJam() >= 1){
            hasil = this.getLamaParkir().getJam();
            if( this.getLamaParkir().getMenit() > 0 || this.getLamaParkir().getDetik() > 0){
                hasil += 1;
            }
        }
        return hasil;
    }

    public int getBiayaParkir(){
        int biaya = 0;
        if (this.jenis == "Motor" || this.jenis == "motor") {
            biaya = getJamParkir()*2000;
        } else if (this.jenis == "Mobil" || this.jenis == "mobil"){
            biaya = getJamParkir()*3000;
        } else {
            return 0;
        }
        return biaya;
    }    
}

class BanyakKendaraan{
    private int banyak;
    private Parkir kendaraan[] = new Parkir[50];

    BanyakKendaraan(int banyak){
        this.banyak = banyak;

        for(int i = 0; i < this.banyak; i++){
            kendaraan[i] = new Parkir();
        }
    }

    public void input(){
        for(int i = 0; i < this.banyak; i++){ 
            System.out.println("\nKendaraan ke-" + (i+1));
            this.kendaraan[i].inputKendaraan();
        }
    }

    public void output(){
        System.out.println("\n\n                            Rekapitulasi Biaya parkir PT Parkir Jaya\n");
            int no = 1;
            System.out.println("=======================================================================================================");
            System.out.println("No  |  No Kendaraan   |   Jenis   |  Jam Masuk  |  Jam keluar  |  Lama Parkir  |  Lama jam  |  Biaya ");
            System.out.println("=======================================================================================================");
            for(int i = 0; i < this.banyak; i++){
                System.out.println(
                    no + "      " +
                    this.kendaraan[i].getNoKendaraan() + "           " + 
                    this.kendaraan[i].getJenis()+ "      " + 
                    this.kendaraan[i].getWaktumasuk().getWaktu() + "      " + 
                    this.kendaraan[i].getWaktukeluar().getWaktu() + "      " +   
                    this.kendaraan[i].getLamaParkir().getWaktu() + "         " + 
                    this.kendaraan[i].getJamParkir() + "         " + 
                    this.kendaraan[i].getBiayaParkir());
                no++;
            }
            System.out.println("=======================================================================================================");
    }

    public float totalBiaya(){
        float hasil = 0;
        for(int i = 0; i < this.banyak; i++){
            hasil += this.kendaraan[i].getBiayaParkir();
        }
        return hasil;
    }
}


public class Soal4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan banyak kendaraan : ");
        int banyak = sc.nextInt();

        BanyakKendaraan parkir = new BanyakKendaraan(banyak);
        parkir.input();
        parkir.output();

        System.out.println("Total Biaya Parkir = " + parkir.totalBiaya());
    }
}
