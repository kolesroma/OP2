package com.example.Lab4;

public class Student {
    private String name;
    private String surname;
    private String id;
    private String rate;

    public Student(String name, String surname, String id, String rate) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
