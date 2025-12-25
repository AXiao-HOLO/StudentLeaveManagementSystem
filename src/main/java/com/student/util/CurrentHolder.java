package com.student.util;

public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    private static final ThreadLocal<String> CURRENT_TYPE_LOCAL = new ThreadLocal<>();

    public static void setCurrentId(Integer userId) {
        CURRENT_LOCAL.set(userId);
    }

    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }

    public static void setCurrentType(String type) {
        CURRENT_TYPE_LOCAL.set(type);
    }

    public static String getCurrentType() {
        return CURRENT_TYPE_LOCAL.get();
    }

    public static void removeType() {
        CURRENT_TYPE_LOCAL.remove();
    }
}
