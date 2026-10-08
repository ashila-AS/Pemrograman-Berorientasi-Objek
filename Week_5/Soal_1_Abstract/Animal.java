public abstract class Animal {
    private String nama;
    private String asal;
    private int jumlahKaki;

    public Animal(String nama, String asal, int jumlahKaki) {
        this.nama = nama;
        this.asal = asal;
        this.jumlahKaki = jumlahKaki;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public int getJumlahKaki() {
        return jumlahKaki;
    }

    public abstract void toShout();

    public void toEat() {
        System.out.println("like to eat");
    }
}