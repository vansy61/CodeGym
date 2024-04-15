import java.util.Arrays;

public class Student {
    private static int lastedId = 0;

    private int id;
    private String name;
    private float[] scores;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(float[] scores) {
        this.scores = scores;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    Student() {};

    Student(String name, String gender,float[] score) {
        this.id = ++Student.lastedId;
        this.name = name;
        this.gender = gender;
        this.scores = score;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAverage() {
        float sum = 0;
        for(float score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + Arrays.toString(scores) +
                ", gender='" + gender + '\'' +
                ", avegareScore='" + getAverage() + '\'' +
                '}';
    }
}
