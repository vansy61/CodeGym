public class StudentManager {
    private Student[] students = new Student[0];

    public void add(Student student) {
        Student[] new_students = new Student[this.students.length + 1];
        System.arraycopy(students, 0, new_students, 0, students.length);
        new_students[new_students.length - 1] = student;
        this.students = new_students;
    }

    public Student[] getStudents() {
        return students;
    }
    

    public Student findById(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student findByName(String name) {
        for(Student student : students) {
            if(student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }

    public void update(int id, String name, String gender, float[] score){
        Student student = findById(id);
        if(student == null) {
            return;
        }

        student.setName(name);
        student.setGender(gender);
        student.setScores(score);
    }

    private boolean checkExits(int id) {
        return findById(id) != null;
    }

    public void remove(int id) {
        if(!checkExits(id)) {
            return;
        }

        Student[] new_students = new Student[students.length - 1];
        int index = 0;
        for(Student student : students) {
            if(student.getId() != id) {
                new_students[index] = student;
                index++;
            }
        }
        this.students = new_students;
    }

    public Student getMaxAverage() {
        Student max_student = students[0];

        for(Student student : students) {
            if(student.getAverage() > max_student.getAverage()) {
                max_student = student;
            }
        }

        return max_student;
    }
}
