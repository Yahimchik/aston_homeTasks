package org.example;

import org.example.util.patternsTask.factoryPattern.factory.CarFactory;
import org.example.util.patternsTask.factoryPattern.factory.SUVFactory;
import org.example.util.patternsTask.factoryPattern.factory.SedanFactory;
import org.example.util.patternsTask.proxyPattern.Database;
import org.example.util.patternsTask.proxyPattern.DatabaseProxy;
import org.example.util.patternsTask.templateMethodPattern.BeverageTemplate;
import org.example.util.patternsTask.templateMethodPattern.Coffee;
import org.example.util.patternsTask.templateMethodPattern.Tea;

public class Main {
    public static void main(String[] args) {
        CarFactory sedan = new SedanFactory();
        CarFactory suv = new SUVFactory();

        sedan.deliverCar();
        suv.deliverCar();

        Database adminDb = new DatabaseProxy("admin");
        Database userDb = new DatabaseProxy("user");

        adminDb.query("select * from users");
        userDb.query("select * from users");

        BeverageTemplate tea = new Tea();
        BeverageTemplate coffee = new Coffee();

        tea.prepareBeverage();
        coffee.prepareBeverage();
    }
}