package org.example.util.patternsTask.templateMethodPattern;

public abstract class BeverageTemplate {

    public final void prepareBeverage() {
        boilWater();
        brew();
        pourIntoCup();
        addCondiments();
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    protected void pourIntoCup(){
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();
}
