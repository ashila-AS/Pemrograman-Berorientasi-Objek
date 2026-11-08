import java.util.ArrayList;
import java.util.Collections;

public class MainArrayList {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(
            101,
            "Budi",
            "Computer Science",
            "Bandung"
        ));

        students.add(new Student(
            102,
            "Aisyah",
            1,
            "Cimahi"
        ));

        students.add(new Student(
            103,
            "Dewi",
            "Electrical Engineering",
            "Lembang"
        ));

        students.add(new Student(
            104,
            "Citra",
            "Computer Science",
            "Garut"
        ));
        
        students.add(new Student(
            105,
            "Eko",
            2,
            "Subang"
        ));

        System.out.println("Sebelum diurutkan:");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(
            students,
            (a, b) -> a.getName().compareTo(b.getName())
        );

        System.out.println();
        System.out.println("Sesudah diurutkan berdasarkan nama:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}