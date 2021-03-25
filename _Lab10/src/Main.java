import java.util.*;

public class Main {
    public static void main(String[] args) {
        University kpi = new University("KPI");
        kpi.addFaculty("FICT");
        kpi.addFaculty("IPSA");
        kpi.addFaculty("FMM");
        kpi.addFaculty("FB");
        kpi.getFaculty("FICT").addStudent("ROMA");
        System.out.println(kpi.getFaculty("FICT").getStudents());
        kpi.getFaculty("FICT").setName("fisting");
        kpi.getFaculty("fisting").getStudent("ROMA").setName("rom4ik");
        kpi.getFaculty("fisting").setName("FICT");
        System.out.println(kpi.getFaculty("FICT").getStudents());
        kpi.getFaculty("IPSA").setStudents(new ArrayList(List.of("artem", "anton", "vasya")));
        System.out.println(kpi.getFaculty("IPSA").getStudents());
        System.out.println(kpi);

    }
}