package com.example.Lab4;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements Comparable<Faculty>{
    private String name;
    private List<Student> students = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student findStudentByName(String stringName) {
        return students.stream()
                .filter(x -> x.getName().equals(stringName))
                .findFirst()
                .orElse(new Student("NO", "ONE", "0", "0"));
    }

    @Override
    public int compareTo(Faculty o) {
        return getName().compareToIgnoreCase(o.getName());
    }
}
