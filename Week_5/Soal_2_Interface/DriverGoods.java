public class DriverGoods {
    public static void main(String[] args) {
        Goods[] barang = {
            new Food("Roti Coklat", 15000, 250),
            new Toy("Lego City", 250000, 6),
            new Book("Pemrograman Java", 120000, "Azka Adziman")
        };

        for (Goods g : barang) {
            g.display();
            System.out.println("-----------------------------");
        }
    }
}