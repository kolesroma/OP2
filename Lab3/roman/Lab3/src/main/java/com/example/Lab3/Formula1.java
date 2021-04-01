package com.example.Lab3;

import static java.lang.Math.*;

public class Formula1 implements IFormulaStrategy{
    @Override
    public double determineFunctionValue(double a, double b, double c, double d) {
        return sqrt(abs(sin(a) - 4 * Math.log(b) / pow(c, d)));
    }

    @Override
    public boolean[] determineOdz(double a, double b, double c, double d) {
        return new boolean[]{true, b > 0, c > 0 || (c < 0 && (d % 1 == 0)) || c == 0 && d <= 0, true};
    }
}
