package org.example.patternsTask.templateMethodPattern;

public class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Coffee brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Coffee add condiments");
    }
}
