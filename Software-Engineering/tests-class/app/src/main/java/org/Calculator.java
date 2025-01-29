package org;

import java.security.InvalidParameterException;
import java.util.stream.DoubleStream;

public class Calculator {
    static double add(double... operands) {
        if(operands == null){
            throw new InvalidParameterException("Operands não pode ser nullo");
        }
        return DoubleStream.of(operands)
                .sum();
    }

    static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }
}