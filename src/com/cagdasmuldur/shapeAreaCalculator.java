package com.cagdasmuldur;
@FunctionalInterface
public interface shapeAreaCalculator<T> {
    double calculate(T shape);
}