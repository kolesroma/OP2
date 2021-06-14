package com.example.Lab4;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class University implements Comparable<University> {
    private String name;
    private Set<Faculty> faculties = new TreeSet<>();

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public Faculty getFacultyByName(String stringName) {
        return faculties.stream()
                .filter(x -> x.getName().equals(stringName))
                .findFirst()
                .orElse(new Faculty("no such faculty"));
    }

    public Faculty findStudentByName(String stringName) {
        return faculties.stream()
                .filter(x -> x.getName().equals(stringName))
                .findFirst()
                .orElse(new Faculty("N0 F4C"));
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(University o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
