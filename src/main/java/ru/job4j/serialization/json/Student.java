package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class Student {
    private final String name;
    private final String surname;
    private final int course;
    private final Contact contact;
    private final boolean expelled;
    private final double[] grades;

    public Student(String name, String surname, int course, Contact contact, boolean expelled, double... grades) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.contact = contact;
        this.expelled = expelled;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public Contact getContact() {
        return contact;
    }

    public boolean isExpelled() {
        return expelled;
    }

    public double[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "{"
                + "name=" + name
                + ", surname=" + surname
                + ", course=" + course
                + ", contact=" + contact
                + ", expelled=" + expelled
                + ", grades=" + Arrays.toString(grades)
                + '}';
    }

    public static void main(String[] args) {
        final Student st1 = new Student("Ivan", "Petrov", 3,
                new Contact("89123456789", "@IvanPetrov"), false, 3.8, 4.6, 3.9);
        final Student st2 = new Student("Stepan", "Ivanov", 2,
                new Contact("89999999999", "@StepanIvanov"), true, 3.1, 3.1, 2.6);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(st1));
        final String st1Json =
                "{"
                    + "\"name\":Ivan,"
                    + "\"surname\":Petrov,"
                    + "\"course\":3,"
                    + "\"contact\":"
                        + "{"
                            + "\"phone\":\"88005553535\","
                            + "\"telegram\":\"@Ivaaaan\""
                        + "},"
                    + "\"expelled\":true,"
                    + "\"grades\":"
                        + "[\"3.3\",\"4.6\",\"2.7\"]"
                + "}";
        final Student studentMod = gson.fromJson(st1Json, Student.class);
        System.out.println(studentMod + System.lineSeparator());

        JSONObject jsonContact = new JSONObject();
        jsonContact.put("phone", st2.getContact().getPhone());
        jsonContact.put("telegram", st2.getContact().getTelegram());
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("name", st2.getName());
        jsonStudent.put("surname", st2.getSurname());
        jsonStudent.put("course", st2.getCourse());
        jsonStudent.put("contact", jsonContact);
        jsonStudent.put("expelled", st2.isExpelled());
        jsonStudent.put("grades", st2.getGrades());

        System.out.println(jsonStudent);
        System.out.println(new JSONObject(st2));
    }
}