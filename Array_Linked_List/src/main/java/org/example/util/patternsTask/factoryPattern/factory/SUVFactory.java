package org.example.util.patternsTask.factoryPattern.factory;

import org.example.util.patternsTask.factoryPattern.Car;
import org.example.util.patternsTask.factoryPattern.SUV;

public class SUVFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new SUV();
    }
}
