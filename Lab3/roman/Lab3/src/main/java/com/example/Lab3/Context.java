package com.example.Lab3;

public class Context {
    public IFormulaStrategy strategy;

    public Context(IFormulaStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double a, double b, double c, double d){
        return strategy.determineFunctionValue(a, b, c, d);
    }

    public boolean[] getOdz(double a, double b, double c, double d) {
        return strategy.determineOdz(a, b, c, d);
    }
}
