package ru.job4j.collection.map;

import java.util.*;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
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
        int firstHash = ivan.hashCode() ^ (ivan.hashCode() >>> 16);
        int secondHash = ivanTheSecond.hashCode() ^ (ivanTheSecond.hashCode() >>> 16);
        int firstBucket = firstHash & (16 - 1);
        int secondBucket = secondHash & (16 - 1);
        System.out.println("first hash = " + firstHash + ", first bucket = " + firstBucket);
        System.out.println("second hash = " + secondHash + ", second bucket = " + secondBucket);
    }
}
