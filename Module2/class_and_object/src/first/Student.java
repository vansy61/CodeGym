package first;

public class Student {
    private String name = "Abc";
    private String classes = "C02";

    Student() {

    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
