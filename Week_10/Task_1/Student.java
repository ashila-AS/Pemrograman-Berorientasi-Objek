public class Student {

    private int studentID;
    private String name;
    private Object department;
    private String address;

    public Student(
        int studentID,
        String name,
        Object department,
        String address
    ) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return studentID
            + " | "
            + name
            + " | "
            + department
            + " | "
            + address;
    }
}