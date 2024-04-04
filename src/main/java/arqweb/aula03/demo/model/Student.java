package arqweb.aula03.demo.model;

public class Student {
    private Long id;
    private String name;
    private String register;
    private int age;
    private String course;
    public Student(Long id, String name, String register, int age, String course){
        this.id = id;
        this.name = name;
        this.register = register;
        this.age = age;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}