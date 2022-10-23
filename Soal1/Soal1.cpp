/* Nama program : Tugas 8 UTS No. 1.cpp
Nama : Gilman Nahdi Al-fathir
NPM : 140810210060
Tanggal buat : 23-10-2022
Deskripsi : pangkat bilangan
******************************************************/

#include<iostream>

using namespace std;

class Pangkat{
    private:
        int angka;
        int pangkat;
    
    public:
        Pangkat(){
            this->angka = 0;
            this->pangkat = 0;
        }
        Pangkat(int angka, int pangkat){
            this->angka = angka;
            this->pangkat = pangkat;
        }
        void setAngka(int angka){
            this->angka = angka;
        }
        int getAngka(){
            return this->angka;
        }
        void setPangkat(int pangkat){
            this->pangkat = pangkat;
        }
        int getPangkat(){
            return this->pangkat;
        }
        void input(){
            cout << "Masukkan angka : ";
            cin >> this->angka;
            cout << "Masukkan pangkat : ";
            cin >> this->pangkat;
        }
        void output(){
            cout << "Hasil pangkat dari " << this->getAngka()<< " pangkat " << this->getPangkat()<< " = " << this->hasilPangkat();
        }
        int hasilPangkat(){
            int hasil = 1;
            for(int i = 1; i <= this->getPangkat(); i++){
                hasil *= this->getAngka();
            }
        return hasil;
        }
};

int main(){
    Pangkat data;
    data.input();
    data.output();
}