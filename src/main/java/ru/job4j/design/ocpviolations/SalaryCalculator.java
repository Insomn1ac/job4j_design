package ru.job4j.design.ocpviolations;

import java.util.List;

public class SalaryCalculator {

    public static class FullTimeEmployee {
        private final String name;
        private final double avgSalary;
        private final int workingDays;

        public FullTimeEmployee(String name, double avgSalary, int workingDays) {
            this.name = name;
            this.avgSalary = avgSalary;
            this.workingDays = workingDays;
        }

        public double getSalary() {
            return avgSalary;
        }

        public int getWorkingDays() {
            return workingDays;
        }

        public double salaryCalc() {
            return avgSalary * workingDays;
        }
    }

    public static class PartTimeEmployee {
        private final String name;
        private final double avgSalary;
        private final int workingDays;

        public PartTimeEmployee(String name, double avgSalary, int workingDays) {
            this.name = name;
            this.avgSalary = avgSalary;
            this.workingDays = workingDays;
        }

        public double getSalary() {
            return avgSalary;
        }

        public int getWorkingDays() {
            return workingDays;
        }

        public double salaryCalc() {
            return (avgSalary * 0.5f) * workingDays;
        }
    }

    public static void main(String[] args) {
        List<Object> empList = List.of(
                new FullTimeEmployee("Ivan", 2100, 22),
                new PartTimeEmployee("Maria", 1200, 17));
        for (Object employee : empList) {
            try {
                FullTimeEmployee emp = (FullTimeEmployee) employee;
                System.out.println(emp.salaryCalc());
            } catch (ClassCastException e) {
                System.out.println("Part-time employee cannot work full-time!");
            }
        }
    }
}
