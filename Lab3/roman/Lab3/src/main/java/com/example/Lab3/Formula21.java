package com.example.Lab3;

import static java.lang.Math.*;

public class Formula21 implements IFormulaStrategy{
    @Override
    public double determineFunctionValue(double a, double b, double c, double d) {
        return 3 * (Math.log(abs(a / b)) + sqrt(cos(c) + exp(d)));
    }

    @Override
    public boolean[] determineOdz(double a, double b, double c, double d) {
        return new boolean[]{true, b != 0, c >= acos(pow(E, d)), true};
    }
}
