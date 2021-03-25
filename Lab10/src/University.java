import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public University() {
        this.name = "no name";
    }

    public Faculty getFaculty(String stringFaculty) {
        Faculty faculty = new Faculty(stringFaculty);
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(stringFaculty))
                return currentFaculty;
        }
        throw new IllegalArgumentException("faculty " + faculty +
                " is not inside the " + name);
    }

    public void addFaculty(String stringFaculty) {
        Faculty faculty = new Faculty(stringFaculty);
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(stringFaculty))
                throw new IllegalArgumentException("faculty " + faculty +
                        " is already inside the " + name);
        }
        faculties.add(faculty);
    }

    public void removeFaculty(String stringFaculty) {
        Faculty faculty = new Faculty(stringFaculty);
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(stringFaculty)) {
                faculties.remove(currentFaculty);
                return;
            }
        }
        throw new IllegalArgumentException("faculty " + faculty +
                " is not inside the " + name);
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

    @Override
    public String toString() {
        return "University:" + name +
                "\nFaculties:" + faculties;
//                "\nStudents" + faculties.;
    }
}
