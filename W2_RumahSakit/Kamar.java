public class Kamar {

    private final String nomorKamar;
    private final String tipeKamar;   
    private boolean tersedia;         

    public Kamar(String nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.tersedia = true; 
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