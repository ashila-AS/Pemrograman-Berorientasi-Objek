public class Chicken extends Animal {

    public Chicken(String nama, String asal, int jumlahKaki) {
        super(nama, asal, jumlahKaki);
    }

    @Override
    public void toShout() {
        System.out.println("Kukuruyuk!");
    }
}