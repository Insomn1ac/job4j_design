package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children + '\''
                + ", hashCode()=" + this.hashCode() + '}';
    }

    public static void main(String[] args) {
        Calendar ivanBirth = new GregorianCalendar(1983, Calendar.NOVEMBER, 24);
        User ivan = new User("Ivan", 2, ivanBirth);
        User ivanTheSecond = new User("Ivan", 2, ivanBirth);
        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(ivan, new Object());
        userObjectMap.put(ivanTheSecond, new Object());
        System.out.println(userObjectMap);
    }
}