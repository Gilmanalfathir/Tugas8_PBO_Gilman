class Waktu:
    __jam = 0
    __menit = 0
    __detik = 0

    def __init__(self, *args) :
          if (len(args) == 3) :
            self.__jam = int(args[0])
            self.__menit = int(args[1])
            self.__detik = int(args[2])
          
          elif(len(args) == 0) :
            self.__jam = int(0)
            self.__menit = int(0)
            self.__detik = int(0)

          else :
            print("inputan anda tidak valid") 

    def setJam(self, jam):
        self.__jam = int(jam)
    
    def getJam(self):
        return self.__jam
    
    def setMenit(self, menit):
        self.__menit = int(menit)
    
    def getMenit(self):
        return self.__menit
    
    def setDetik(self, detik):
        self.__detik = int(detik)
    
    def getDetik(self):
        return self.__detik
    
    def inputWaktu(self):
        self.__jam = int(input(" Masukkan jam : "))
        self.__menit = int(input(" Masukkan menit : "))
        self.__detik = int(input(" Masukkan detik : "))
    
    def getWaktu(self):
        nJam = ""
        nMenit = ""
        nDetik = ""
        if(self.__jam < 10):
            nJam = "0"
        if(self.__menit < 10):
            nMenit = "0"
        if(self.__detik < 10):
            nDetik = "0"
        return nJam + str(self.__jam) + ":" + nMenit + str(self.__menit) + ":" + nDetik + str(self.__detik)

    def totalDetik(self):
        hasil = (int(3600) * self.__jam) + (int(60) * self.__menit) + self.__detik
        return hasil
    
    def waktuTotal(self, dtk:int):
        self.__menit = int(dtk/60)
        self.__detik = int(dtk%60)
        self.__jam = int(self.__menit/60)
        self.__menit = int(self.__menit%60)
    
    def cariDurasi(self, akhir):
        temp = Waktu()
        detikAwal = self.totalDetik()
        detikAkhir = akhir.totalDetik()
        if(detikAkhir < detikAwal):
            detikAkhir += 86400
        detikHasil = detikAkhir - detikAwal
        temp.waktuTotal(detikHasil)

        return temp

class Parkir:
    __no = ""
    __jenis = ""
    __masuk = Waktu()
    __keluar = Waktu()

    def __init__(self):
        self.__no = ""
        self.__jenis = ""
        self.__masuk = Waktu(0, 0, 0)
        self.__keluar = Waktu(0, 0, 0)

    def setNoKendaraan(self,no):
        self.__no = no
    
    def getNoKendaraan(self):
        return self.__no
    
    def setJenis(self, jenis):
        self.__jenis = jenis

    def getJenis(self):
        return self.__jenis
    
    def setWaktuMasuk(self, masuk):
        self.__masuk = masuk
    
    def getWaktuMasuk(self):
        return self.__masuk
    
    def setWaktuKeluar(self, keluar):
        self.__keluar = keluar
    
    def getWaktuKeluar(self):
        return self.__keluar
    
    def inputKendaraan(self):
        self.__no = input("No Kendaraan : ")
        self.__jenis = input("Jenis Kendaraan (Mobil/Motor): ")
        print("Jam Masuk: ")
        self.__masuk.inputWaktu()
        print("Jam Keluar: ")
        self.__keluar.inputWaktu()
    
    def getLamaParkir(self):
        return self.__masuk.cariDurasi(self.__keluar)
    
    def getJamParkir(self):
        hasil = 0
        if(self.getLamaParkir().getMenit()>=10 or self.getLamaParkir().getJam() >= 1):
            hasil = self.getLamaParkir().getJam()
            if(self.getLamaParkir().getMenit()>0 or self.getLamaParkir().getDetik() > 0):
                hasil = hasil + 1
        
        return hasil
    
    def getBiayaParkir(self):
        biaya = 0
        if(self.__jenis == "Motor"):
            biaya = self.getJamParkir() * 2000
        elif(self.__jenis == "Mobil"):
            biaya = self.getJamParkir() * 3000
        
        return biaya

class banyakKendaraan:
    __banyak = 0
    __kendaraan = []

    def __init__(self, banyak):
        self.__banyak = banyak

    def input(self):
        i = 0
        while(i < self.__banyak):
            print("\nKendaraan ke-", i+1)
            data = Parkir()
            data.inputKendaraan()
            self.__kendaraan.append(data)
            i += 1

    def output(self):
        print("\n\n                            Rekapitulasi Biaya parkir PT Parkir Jaya\n")
        no = int(1)
        i = int(0)
        print("=======================================================================================================")
        print("No  |  No Kendaraan   |   Jenis   |  Jam Masuk  |  Jam keluar  |  Lama Parkir  |  Lama jam  |  Biaya ")
        print("=======================================================================================================")
        while(i < self.__banyak):
            print(
            no, "    ",
            self.__kendaraan[i].getNoKendaraan(), "        ", 
            self.__kendaraan[i].getJenis(), "     ", 
            self.__kendaraan[i].getWaktuMasuk().getWaktu(), "     ", 
            self.__kendaraan[i].getWaktuKeluar().getWaktu(), "     ",   
            self.__kendaraan[i].getLamaParkir().getWaktu(), "      ", 
            self.__kendaraan[i].getJamParkir(), "        ", 
            self.__kendaraan[i].getBiayaParkir())
            no += 1
            i += 1
        print("=======================================================================================================")
    
    def totalBiaya(self):
        hasil = float(0)
        i = int(0)
        while(i<self.__banyak):
            hasil = hasil + self.__kendaraan[i].getBiayaParkir()
            i = i + 1
        return hasil

banyak = int(input("Masukkan banyak kendaraan : "))
parkir = banyakKendaraan(banyak)
parkir.input()
parkir.output()
print("Total Biaya Parkir = ", parkir.totalBiaya())