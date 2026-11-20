public class Produk {
    private final String id;
    private final String nama;
    private final int harga;

    public Produk(String id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public int getHarga() { return harga; }
}