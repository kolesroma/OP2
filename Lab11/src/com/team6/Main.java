package com.team6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

public class Main {
    public static void main(String[] args) {
        // Reference to a constructor
        CreateDiscriminant newDiscr = Discriminant::new;

        List<Discriminant> discriminantList = new ArrayList<>(List.of(
                newDiscr.create(1, 0, 1), // no roots
                newDiscr.create(3, 6, 1), // 2 roots
                newDiscr.create(1, 2, 1), // 1 root
                newDiscr.create(1, -2, 1) /* 1 root */));

        discriminantList.stream()
                // Reference to a Static Method
                // .filter(eq1 -> hasRoots(eq1))
                .filter(Main::hasRoots)
                // Reference to an Instance Method of object
                // .forEach(x -> System.out.println(x));
                .forEach(System.out::println);

        Discriminant eq = newDiscr.create(9, 6, 1);
        // Reference to an Instance Method of object
        // DoubleConsumer dc = a -> eq.setA(a);
        DoubleConsumer dc = eq::setA;
        dc.accept(2);

        // Reference to an instance method of class
        Discriminant eq2 = new Discriminant(9, 6, 1);
        // CompDiscriminant cd = (d1, d2) -> d1.equals(d2);
        CompDiscriminant cd = Discriminant::equals;
        System.out.println(cd.test(eq, eq2));
    }

    public static boolean hasRoots(Discriminant eq) {
        return eq.solve().length > 0;
    }
}
