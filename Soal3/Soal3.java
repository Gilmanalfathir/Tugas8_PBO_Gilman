/* Nama program : Tugas 8 UTS No. 3.java
Nama : Gilman Nahdi Al-fathir
NPM : 140810210060
Tanggal buat : 23-10-2022
Deskripsi : Matriks jadi 0 atau 1
******************************************************/

import java.util.Scanner;
class Matriks {
    private int baris;
    private int kolom;
    private int[][] nilai;

    public Matriks(){
        baris = 0;
        kolom = 0;
        nilai = new int[baris][kolom];
    }

    public Matriks(int baris, int kolom){
        this.baris = baris;
        this.kolom = kolom;
        nilai = new int[baris][kolom];
    }

    public void setUkuran(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        nilai = new int[baris][kolom];
    }

    public int getBaris() {
        return baris;
    }

    public int getKolom() {
        return kolom;
    }

    public void inputNilai(){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Masukkan isi indeks (" + (i+1) + "," + (j+1) + ") : ");
                nilai[i][j] = scan.nextInt();
            }
        }
    }

    public void cetakMatriks(){
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(" " + nilai[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public int[][] hasilMatriks(Matriks A, Matriks B){
        int[][] result = new int[baris][kolom];
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                if (A.nilai[i][j] >= B.nilai[i][j]){
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(" " + result[i][j] + "\t");
            }
            System.out.println("");
        }
        return result;
    }
}

class Soal3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matriks A = new Matriks();
        Matriks B = new Matriks();
        Matriks C = new Matriks();

        System.out.print("Masukkan ukuran ordo matriks : ");
        A.setUkuran(sc.nextInt(), sc.nextInt());
        B.setUkuran(A.getBaris(), A.getKolom());
        C.setUkuran(A.getBaris(), A.getKolom());
        
        System.out.println("\nInput nilai Matriks 1 : ");
        A.inputNilai();
        System.out.println("\nInput nilai Matriks 2 : ");
        B.inputNilai();
        
        System.out.println("\nMatriks 1 : ");
        A.cetakMatriks();
        System.out.println("\nMatriks 2 : ");
        B.cetakMatriks();
        
        System.out.println("\nHasil :");
        C.hasilMatriks(A, B);
        
        sc.close();
    }
}