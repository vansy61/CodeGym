import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        float[] firstStudentScore = {2,3,4};
        manager.add(new Student("Test 01", "male", firstStudentScore));
        float[] secondStudentScore = {7,9,8};
        manager.add(new Student("Hello1", "female", secondStudentScore));
        float[] thirdStudentScore = {3,2,8};
        manager.add(new Student("Hello1", "female", thirdStudentScore));

        System.out.println(Arrays.toString(manager.getStudents()));

        Student student = manager.findById(2);
        if(student != null) {
            System.out.println(student.getAverage());
        }

        Student student1 = manager.findByName("Test");
        if(student1 != null) {
            System.out.println(student1.getAverage());
        }

        manager.remove(1);
        System.out.println(Arrays.toString(manager.getStudents()));

        float[] newStudentScore = {5,0,10};
        manager.update(3, "New name", "new gender", newStudentScore);
        System.out.println(Arrays.toString(manager.getStudents()));

        System.out.println(manager.getMaxAverage());
    }
}