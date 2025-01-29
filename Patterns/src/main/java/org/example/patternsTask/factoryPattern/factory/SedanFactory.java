package org.example.patternsTask.factoryPattern.factory;

import org.example.patternsTask.factoryPattern.Car;
import org.example.patternsTask.factoryPattern.Sedan;

public class SedanFactory extends CarFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }
}
