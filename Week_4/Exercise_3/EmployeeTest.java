public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        int i;
        for (i = 0; i < 3; i++) staff[i].raiseSalary(5);

        System.out.println("=== Setelah raiseSalary(5) ===");
        for (i = 0; i < 3; i++) staff[i].print();

        System.out.println("\n=== Coba compare() ===");
        System.out.println("Antonio vs Maria  : " + staff[0].compare(staff[1]));
        System.out.println("Isabel  vs Maria  : " + staff[2].compare(staff[1]));
        System.out.println("Maria   vs Maria  : " + staff[1].compare(staff[1]));

        Employee tmp = staff[0];
        staff[0] = staff[2];
        staff[2] = tmp;

        System.out.println("\n=== Sebelum shell_sort (urutan dibalik) ===");
        for (i = 0; i < 3; i++) staff[i].print();

        Sortable.shell_sort(staff);

        System.out.println("\n=== Sesudah shell_sort (urut salary naik) ===");
        for (i = 0; i < 3; i++) staff[i].print();
    }
}