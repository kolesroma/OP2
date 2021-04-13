import java.util.*;
import java.util.function.ToDoubleFunction;

public class Main {
    public static void main(String[] args) {
        Discriminant eq1 = new Discriminant(1, 0, 1); // no roots
        Discriminant eq2 = new Discriminant(3, 6, 1); // 2 roots
        Discriminant eq3 = new Discriminant(1, 2, 1); // 1 root
        Discriminant eq4 = new Discriminant(1, -2, 1); // 1 root

        ArrayList<Discriminant> all = new ArrayList<>(List.of(eq1, eq2, eq3, eq4));
        System.out.println("unsorted ArrayList");
        System.out.println(all);

        // sorting by root quantity rising
        Comparator<Discriminant> rootRisingComparator = Comparator.comparingInt(x -> x.solve().length);
        all.sort(rootRisingComparator);
        System.out.println("sorting by root quantity rising");
        System.out.println(all);

        // sorting by root quantity descending
        Comparator<Discriminant> rootDescendingComparator = rootRisingComparator.reversed();
        all.sort(rootDescendingComparator);
        System.out.println("sorting by root quantity descending");
        System.out.println(all);

        // anonymous class compare by coefficient a
        Comparator<Discriminant> coefficientComparator = new Comparator<>() {
            @Override
            public int compare(Discriminant o1, Discriminant o2) {
                return (int) (o1.getA() - o2.getA());
            }
        };

        //chain of comparators
        Comparator<Discriminant> vertexComparator = Comparator.comparingDouble(Discriminant::getParabolaVertexAbscissa);
        Comparator<Discriminant> abscissaCoefficientElementComparator =
                vertexComparator.thenComparing(coefficientComparator).thenComparing(new MaxElementComparator());
        all.sort(abscissaCoefficientElementComparator);
        System.out.println("chain of comparators");
        System.out.println(all);

        // null friendly
        all.add(null);
        Comparator<Discriminant> vertexNullComparator = Comparator.nullsFirst(vertexComparator);
        all.sort(vertexNullComparator);
        System.out.println("null friendly");
        System.out.println(all);
    }

    private static class MaxElementComparator implements Comparator<Discriminant> {
        @Override
        public int compare(Discriminant o1, Discriminant o2) {
            return (int) (Arrays.stream(o1.solve()).max().getAsDouble() - Arrays.stream(o2.solve()).max().getAsDouble());
        }
    }
}