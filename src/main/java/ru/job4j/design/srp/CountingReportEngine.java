package ru.job4j.design.srp;

import java.util.function.Predicate;

public class CountingReportEngine implements Report {
    private final Store store;

    public CountingReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(String.format("%.1f", employee.getSalary() / 73.65)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
