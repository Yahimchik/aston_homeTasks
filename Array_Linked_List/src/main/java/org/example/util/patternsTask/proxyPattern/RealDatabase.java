package org.example.util.patternsTask.proxyPattern;

public class RealDatabase implements Database {
    @Override
    public void query(String sql) {
        System.out.println("query: " + sql);
    }
}
