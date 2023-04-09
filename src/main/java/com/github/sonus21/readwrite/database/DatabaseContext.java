package com.github.sonus21.readwrite.database;

public class DatabaseContext {
    private static final ThreadLocal<String> databaseName = new ThreadLocal<>();

    public static void set(String name) {
        databaseName.set(name);
    }

    public static void clear() {
        databaseName.remove();
    }

    public static String get() {
        return databaseName.get();
    }

}
