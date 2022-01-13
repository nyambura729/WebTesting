package com.spartaglobal.nc;

public class Calculator {
    private double num1;
    private double num2;

    public Calculator(double n1, double n2) {
        this.num1 = n1;
        this.num2 = n2;
    }

    public void setNum1(double n1) {
        num1 = n1;
    }

    public void setNum2(double n2) {
        num2 = n2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double add() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public boolean divisibleBy() {
        return num1 % num2 == 0;
    }
}
