package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JsonReportEngine implements Report {
    private final Store store;

    public JsonReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson report = new GsonBuilder().create();
        return report.toJson(store.findBy(filter));
    }
}
