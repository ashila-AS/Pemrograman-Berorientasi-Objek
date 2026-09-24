package id.ac.polban.model;

public class Kamar {
    private static int totalKamar = 0;

    private final String nomorKamar;
    private final String tipeKamar;
    private boolean tersedia;

    public Kamar(String nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.tersedia = true;
        totalKamar++;
    }

    public static int getTotalKamar() {
        return totalKamar;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void tampilkanBaris() {
        String status = tersedia ? "Tersedia" : "Terisi";
        System.out.printf("| %-10s | %-14s | %-12s |%n", nomorKamar, tipeKamar, status);
    }
}