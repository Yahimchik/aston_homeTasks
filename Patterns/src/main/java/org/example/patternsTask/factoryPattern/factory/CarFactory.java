package org.example.patternsTask.factoryPattern.factory;

import org.example.patternsTask.factoryPattern.Car;

public abstract class CarFactory {
    public abstract Car createCar();

    public void deliverCar(){
        Car car = createCar();
        System.out.println("Доставка автомобиля");
        car.drive();
    }
}
