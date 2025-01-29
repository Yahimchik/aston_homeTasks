package org.example.patternsTask.factoryPattern.factory;

import org.example.patternsTask.factoryPattern.Car;
import org.example.patternsTask.factoryPattern.SUV;

public class SUVFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new SUV();
    }
}
