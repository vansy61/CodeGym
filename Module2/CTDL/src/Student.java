public class Student {
    private static int lastedId = 0;
    private int id;
    private String name;
    private String email;
    private double gpa;


    Student(String name, String email, double gpa) {
        this.name = name;
        this.email = email;
        this.gpa = gpa;
        this.id = ++lastedId;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                '}';
    }
}
