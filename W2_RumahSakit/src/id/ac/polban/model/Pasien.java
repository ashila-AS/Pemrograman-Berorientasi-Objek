package id.ac.polban.model;

public class Pasien {
    private static int counterPasien = 0;

    private final String idPasien;
    private final String nama;
    private int hariMasuk;
    private int hariKeluar;
    private Kamar kamar;

    public Pasien(String nama) {
        counterPasien++;
        this.idPasien = String.format("P%03d", counterPasien);
        this.nama = nama;
        this.hariKeluar = -1;
    }

    public Pasien(String idPasien, String nama) {
        counterPasien++;
        this.idPasien = idPasien;
        this.nama = nama;
        this.hariKeluar = -1;
    }

    public static int getTotalPasien() {
        return counterPasien;
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