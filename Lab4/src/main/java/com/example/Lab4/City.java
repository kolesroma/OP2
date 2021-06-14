package com.example.Lab4;

import java.util.Set;
import java.util.TreeSet;

public class City{
    private static Set<University> universities = new TreeSet<>();

    public Set<University> getUniversities() {
        return universities;
    }

    public void addUniversity(University university) {
        universities.add(university);
    }

    public University findUniversityByName(String stringName) {
        return universities.stream()
                .filter(x -> x.getName().equals(stringName))
                .findFirst()
                .orElse(new University("NONE"));
    }
}
