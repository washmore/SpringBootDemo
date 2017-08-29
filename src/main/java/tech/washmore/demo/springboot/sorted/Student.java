package tech.washmore.demo.springboot.sorted;

public class Student implements Comparable<Student> {
    private int age;
    private String nameEn;
    private int grade;

    public Student() {

    }


    public Student(int age, String nameEn, int grade) {
        this.age = age;
        this.nameEn = nameEn;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.getAge(), s.getAge());
    }
}
