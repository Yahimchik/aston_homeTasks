package org.example.util.patternsTask.factoryPattern.factory;

import org.example.util.patternsTask.factoryPattern.Car;
import org.example.util.patternsTask.factoryPattern.Sedan;

public class SedanFactory extends CarFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }
}
