package org.example.util.patternsTask.templateMethodPattern;

public class Tea extends BeverageTemplate{
    @Override
    protected void brew() {
        System.out.println("Tea brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Tea add condiments");
    }
}
