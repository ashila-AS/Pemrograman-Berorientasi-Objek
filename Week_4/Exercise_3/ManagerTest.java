public class ManagerTest {
    public static void main(String[] args) {
        
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        int i;
        for (i = 0; i < 3; i++) staff[i].raiseSalary(5);

        System.out.println("=== Employee dan Manager dicampur (raiseSalary 5) ===");
        for (i = 0; i < 3; i++) staff[i].print();

        Manager[] managers = new Manager[3];
        managers[0] = new Manager("Budi Santoso", 5000000, 1, 5, 2010);
        managers[1] = new Manager("Citra Dewi", 3000000, 1, 6, 2015);
        managers[2] = new Manager("Dedi Pratama", 4000000, 1, 7, 2005);

        System.out.println("\n=== Manager sebelum shell_sort ===");
        for (i = 0; i < 3; i++) managers[i].print();

        Sortable.shell_sort(managers);

        System.out.println("\n=== Manager sesudah shell_sort (urut salary naik) ===");
        for (i = 0; i < 3; i++) managers[i].print();
    }
}