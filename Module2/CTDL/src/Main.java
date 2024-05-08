import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArrayList listStudent = new MyArrayList();

        Student student1 = new Student("Student 1", "test01@gmail.com", 9);
        Student student2 = new Student("Student 2", "test02@gmail.com", 6.2);
        Student student3 = new Student("Student 3", "test03@gmail.com", 7.1);

        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);

        System.out.println("===== Danh sách sinh viên trước khi xóa =====");
        listStudent.show();
        listStudent.remove(1);
        System.out.println("===== Danh sách sinh viên sau khi xóa =====");
        listStudent.show();

        System.out.println("===== Danh sách sinh viên gpa > 8 =====");
        for (int i = 0; i < listStudent.size(); i++) {
            Student student = (Student) listStudent.get(i);
            if(student.getGpa() > 8) {
                System.out.println();
            }
        }
    }
}