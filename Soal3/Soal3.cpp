/* Nama program : Tugas 8 UTS No. 3.cpp
Nama : Gilman Nahdi Al-fathir
NPM : 140810210060
Tanggal buat : 23-10-2022
Deskripsi : Matriks jadi 0 atau 1
******************************************************/

#include <iostream>

using namespace std;

class Matriks{
    private:
    int baris;
    int kolom;
    int nilai[10][10];

    public :
    Matriks(){
        baris = 0;
        kolom = 0;
    }
    Matriks(int baris, int kolom){
        this->baris = baris;
        this->kolom = kolom;
    }
    void setBaris(int baris) {
        this->baris = baris;
    }
    int getBaris(){
        return baris;
    }
    void setKolom(int kolom) {
        this->kolom = kolom;
    }
    int getKolom(){
        return kolom;
    }
    void inputNilai(){
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                cout << "Masukkan isi indeks (" + to_string((i + 1)) + "," + to_string((j + 1)) + ") : ";
                cin >> this->nilai[i][j];
            }
        }
    }
    void cetakMatriks(){
        for(int i = 0; i < this->baris; i++){
            for(int j=0; j < this->kolom; j++){
                cout << " " << this->nilai[i][j] << "\t";
            }
            cout<<"\n";
        }
    }
    Matriks hasilMatriks(Matriks A, Matriks B, Matriks C){
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                if (A.nilai[i][j] >= B.nilai[i][j]) {
                    C.nilai[i][j] = 1;
                } else {
                    C.nilai[i][j] = 0;
                }
            }
        }
        return C;
    };
};

int main(int argc, char **argv){
    int ko, ba;
    Matriks A;
    Matriks B;
    Matriks C;
    cout << "Masukkan ukuran ordo matriks : ";
    cin >> ba; cin >> ko;
    A.setBaris(ba); A.setKolom(ko);
    B.setBaris(ba); B.setKolom(ko);
    C.setBaris(ba); C.setKolom(ko);
    cout << "\nInput nilai Matriks 1 : " << endl;
    A.inputNilai();
    cout << "\nInput nilai Matriks 2 : " << endl;
    B.inputNilai();
    cout << "\nMatriks 1 : " << endl;
    A.cetakMatriks();
    cout << "\nMatriks 2 : " << endl;
    B.cetakMatriks();
    cout << "\nHasil :" << endl;
    C = C.hasilMatriks(A, B, C);
    C.cetakMatriks();
}