package com.example.Lab3;

import static java.lang.Math.*;

public class Formula11 implements IFormulaStrategy{
    @Override
    public double determineFunctionValue(double a, double b, double c, double d) {
        return 9*asin(a) / cos(sqrt(abs(b))) + pow(2.43, d) + Math.log(c);
    }

    @Override
    public boolean[] determineOdz(double a, double b, double c, double d) {
        return new boolean[]{a <= 1 && a >= -1, b % PI != 0, c > 0, true};
    }
}
