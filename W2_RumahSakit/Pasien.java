public class Pasien {
  
    private final String idPasien;
    private final String nama;
    private int hariMasuk;   
    private int hariKeluar;  
    private Kamar kamar;     

    public Pasien(String idPasien, String nama) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.hariKeluar = -1; 
        this.kamar = null;    
    }

    public String getIdPasien() {
        return idPasien;
    }

    public String getNama() {
        return nama;
    }

    public int getHariMasuk() {
        return hariMasuk;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setHariMasuk(int hariMasuk) {
        this.hariMasuk = hariMasuk;
    }

    public void setHariKeluar(int hariKeluar) {
        this.hariKeluar = hariKeluar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public int hitungLamaInap() {
        if (hariKeluar == -1) {
            return -1; 
        }
        return hariKeluar - hariMasuk;
    }
}