# Nama program : Tugas 8 UTS No. 1.py
# Nama : Gilman Nahdi Al-fathir
# NPM : 140810210060
# Tanggal buat : 23-10-2022
# Deskripsi : pangkat bilangan
#-------------------------------------------------

class Pangkat:
    __angka = int(0)
    __pangkat = int(0)

    def __init__(self):
        self.__angka = 0
        self.__pangkat = 0
        
    def setAngka(self, angka):
        self.__angka = angka
        
    def setPangkat(self, pangkat):
        self.__pangkat = pangkat
        
    def getAngka(self):
        return int(self.__angka)
    
    def getPangkat(self):
        return int(self.__pangkat)
    
    def inputData(self):
        self.setAngka(int(input("Masukkan angka :")))
        self.setPangkat(int(input("Masukkan pangkat :")))
        
    def outputData(self):
        print("Hasil pangkat dari ", self.getAngka(), " pangkat ", self.getPangkat(), " = ", self.hasilPangkat())
    
    def hasilPangkat(self):
        i = int(1)
        hasil = int(1)
        while(i <= self.getPangkat()):
            hasil = hasil * self.getAngka()
            i = int(i) + int(1)
        return hasil

# class main:
data = Pangkat()
data.inputData()
data.outputData()