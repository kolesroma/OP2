package com.team6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TreeSet<Candidate> candidateList = new TreeSet<>(Arrays.asList(new Candidate("roma", 92),
                new Candidate("artem", 61),
                new Candidate("dima", 74),
                new Candidate("naruto", 0),
                new Candidate("lee", 27)));
        System.out.println(">>original list:");
        candidateList.forEach(System.out::println);
        System.out.println(">>contract list:");
        printContractList(candidateList, 1, 3);
        System.out.println("========");


        Institute kpi = new Institute("KPI");
        Faculty fics = new Faculty("FICS");
        Faculty ipsa = new Faculty("IPSA");
        kpi.addFaculty(fics);
        kpi.addFaculty(ipsa);
        Student roma = new Student("roma","koles", 88888, 92);
        Student dima = new Student("dima","kubic", 6666, 69);
        Student anton = new Student("anton","poliv", 555, 77);
        fics.addStudent(roma);
        fics.addStudent(dima);
        fics.addStudent(anton);
        ipsa.addStudent(anton);
        Comparator<Student> surnameNameIdComparator = Comparator.comparing(Student::getSurname)
                .thenComparing(Student::getName)
                .thenComparing(Student::getId);
        System.out.println(">>all students:");
        printAllStudents(kpi, surnameNameIdComparator);
        System.out.println("========");

        System.out.println(">>cannot be admitted:");
        System.out.println(getRejectedCandidateSurnames(candidateList));
    }

    public static void printContractList(TreeSet<Candidate> candidateList, int budgetSize, int contractSize) {
        candidateList.stream()
                .filter(candidate -> candidate.getScore() > 60)
                .skip(budgetSize)
                .limit(contractSize)
                .forEach(System.out::println);
    }

    public static void printAllStudents(Institute institute, Comparator<Student> comparator) {
        Stream.of(institute)
                .flatMap(order -> order.getFaculties().stream())
                .flatMap(order -> order.getStudents().stream())
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static List<String> getRejectedCandidateSurnames(TreeSet<Candidate> candidateList) {
        return candidateList.stream()
                .filter(candidate -> candidate.getScore() <= 60)
                .map(Candidate::getName)
                .collect(Collectors.toList());
    }
}
