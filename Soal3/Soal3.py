# Nama program : Tugas 8 UTS No. 3.py
# Nama : Gilman Nahdi Al-fathir
# NPM : 140810210060
# Tanggal buat : 23-10-2022
# Deskripsi : Matriks jadi 0 atau 1
#-------------------------------------------------

class Matriks:
    __baris = int(0)
    __kolom = int(0)
    __nilai = []

    def __init__(self, baris, kolom):
        self.__baris = baris
        self.__kolom = kolom
        self.__nilai = []
      
    def setBaris(self, baris):
        self.__baris = baris
    
    def getBaris(self):
        return self.__baris
    
    def setKolom(self, kolom):
        self.__kolom = kolom
    
    def getKolom(self):
        return self.__kolom
        
    def inputNilai(self) :
        bil = int(0)
        i = int(0)
        while (i < self.getBaris()) :
            a = []
            j = int(0)
            while (j < self.getKolom()) :
                print("Masukkan isi indeks (", i + 1, ",", j + 1, ")", end =": ")
                bil = int(input())
                a.append(bil)
                j += 1
            self.__nilai.append(a)
            i += 1
            
    def cetakMatriks(self) :
        i = int(0)
        while (i < self.getBaris()) :
            j = int(0)
            while (j < self.getKolom()) :
                print(self.__nilai[i][j],"\t", end =" ")
                j += 1
            print(" ")
            i += 1
            
    def hasilMatriks(self, A, B, C) :
        bil = int(0)
        i = int(0)
        while (i < self.getBaris()) :
            c = []
            j = int(0)
            while (j < self.getKolom()) :
                if (A.__nilai[i][j] >= B.__nilai[i][j]) :
                    bil = int(1)
                else :
                    bil = int(0)
                c.append(bil)
                j += 1
            C.__nilai.append(c)
            i += 1
    
print("Masukkan ukuran ordo matriks : ")
ko = int(input("kolom : "))
ba = int(input("baris : "))

A = Matriks(ba, ko)
B = Matriks(ba, ko)
C = Matriks(ba, ko)

print("\nInput nilai Matriks 1 : ")
A.inputNilai()

print("\nInput nilai Matriks 2 : ")
B.inputNilai()

print("\nMatriks 1 : ")
A.cetakMatriks()

print("\nMatriks 2 : ")
B.cetakMatriks()

print("\nHasil :")
C.hasilMatriks(A, B, C)
C.cetakMatriks()