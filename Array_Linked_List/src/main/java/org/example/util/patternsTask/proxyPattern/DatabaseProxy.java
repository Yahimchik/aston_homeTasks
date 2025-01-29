package org.example.util.patternsTask.proxyPattern;

public class DatabaseProxy implements Database {

    private RealDatabase database;
    private String userRole;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void query(String sql) {
        if (userRole.equals("admin")) {
            if (database == null) {
                database = new RealDatabase();
            }
            database.query(sql);
        } else {
            System.out.println("Forbidden");
        }
    }
}
