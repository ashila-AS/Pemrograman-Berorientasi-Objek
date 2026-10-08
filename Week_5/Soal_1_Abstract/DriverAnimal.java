public class DriverAnimal {
    public static void main(String[] args) {
        Animal[] hewan = {
            new Dog("Niki", "Indonesia", 4),
            new Chicken("Rambo", "Indonesia", 2),
            new Lion("King", "Afrika", 4)
        };

        for (Animal a : hewan) {
            System.out.println("Nama       : " + a.getNama());
            System.out.println("Asal       : " + a.getAsal());
            System.out.println("Jumlah kaki: " + a.getJumlahKaki());
            System.out.print("Suara      : ");
            a.toShout();
            System.out.print("Makan      : " + a.getNama() + " ");
            a.toEat();
            System.out.println("-----------------------------");
        }
    }
}