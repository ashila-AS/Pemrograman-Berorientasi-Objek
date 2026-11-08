import java.util.Vector;

public class MainVector {

    public static void main(String[] args) {

        Vector<Student> students = new Vector<Student>();

        students.add(new Student(
            201,
            "Fajar",
            "Computer Science",
            "Bandung"
        ));

        students.add(new Student(
            202,
            "Gita",
            "Electrical Engineering",
            "Cimahi"
        ));

        students.add(new Student(
            203,
            "Hana",
            "Computer Science",
            "Lembang"
        ));

        students.add(new Student(
            204,
            "Indra",
            3,
            "Garut"
        ));
        
        students.add(new Student(
            205,
            "Joko",
            "Computer Science",
            "Subang"
        ));

        System.out.println("Semua mahasiswa:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Mahasiswa Computer Science:");
        for (Student s : students) {
            if ("Computer Science".equals(s.getDepartment())) {
                System.out.println(s);
            }
        }
    }
}