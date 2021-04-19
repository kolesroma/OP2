package com.team6;

import java.util.Arrays;
import java.util.Objects;

public class Discriminant implements SolvingAlgorithm {
    private double a;
    private double b;
    private double c;

    public Discriminant(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Discriminant() {
    }

    @Override
    public double[] solve() {
        double sqrtD = Math.sqrt(b * b - 4 * a * c);
        if (!Double.isFinite(sqrtD))
            return new double[] {};
        double x1 = (-b + sqrtD) / 2*a;
        double x2 = (-b - sqrtD) / 2*a;
        if (x1 == x2)
            return new double[] {x1};
        return new double[] {x1, x2};
    }

    public double getParabolaVertexAbscissa() {
        return -b / 2*a;
    }

    public double[] getAll() {
        return new double[] {a, b, c};
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discriminant that = (Discriminant) o;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 && Double.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return a + " b: " + b + " c: " + c + " roots: " + Arrays.toString(solve());
    }
}
