public class ItemKeranjang {
    private final Produk produk;
    private int qty;

    public ItemKeranjang(Produk produk, int qty) {
        this.produk = produk;
        this.qty = qty;
    }

    public Produk getProduk() { return produk; }
    public int getQty() { return qty; }

    public void tambahQty(int tambahan) {
        this.qty += tambahan;
    }

    public int getSubtotal() {
        return produk.getHarga() * qty;
    }
}