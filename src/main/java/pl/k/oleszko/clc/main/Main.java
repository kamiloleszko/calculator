package pl.k.oleszko.clc.main;

import pl.k.oleszko.clc.service.calculator.Calculator;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Calculator calculator = new Calculator();
        calculator.calculate("input.txt");
    }
}
