import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        CountExpression formula1 = (a, b, c, d) -> sqrt(abs(sin(a) - 4 * log(b) / pow(c, d)));
        CountExpression formula11 = (a, b, c, d) -> asin(a) / cos(sqrt(abs(b))) + pow(2.43, d) + Math.log(c);
        CountExpression formula21 = (a, b, c, d) -> 3 * (Math.log(abs(a / b)) + sqrt(cos(c) + exp(d)));

        System.out.println("formula1: " + countWithFunction(formula1, 1, 0, 3, 4));
        System.out.println("formula11: " + countWithFunction(formula11, 1, 2, 3, 4));
        System.out.println("formula21: " + countWithFunction(formula21, 1, 0, 3, 4));

        System.out.println("\nequations:");
        List<Discriminant> discriminantList = new ArrayList<>(List.of(
                new Discriminant(1, 0, 1), // no roots
                new Discriminant(3, 6, 1), // 2 roots
                new Discriminant(1, 2, 1), // 1 root
                new Discriminant(1, -2, 1) /* 1 root  */));
        discriminantList.forEach(equation -> System.out.println(equation));
    }

    public static double countWithFunction(CountExpression formula, double a, double b, double c, double d) {
        double result = formula.calculate(a, b, c, d);
        return Double.isFinite(result) ? result : -1;
    }
}
