import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public Student getStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent))
                return currentStudent;
        }
        throw new IllegalArgumentException("student " + stringStudent
                + " is not inside the " + name);
    }

    public void addStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent)) {
                throw new IllegalArgumentException("student " + stringStudent
                        + " is already inside the " + name);
            }
        }
        students.add(student);
    }

    public void removeStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent)) {
                students.remove(currentStudent);
                return;
            }
        }
        throw new IllegalArgumentException("student " + stringStudent
                + " is not inside the " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name;
    }
}
