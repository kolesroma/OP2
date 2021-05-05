package com.team6;

import java.util.ArrayList;

public class Institute {
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public Institute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
