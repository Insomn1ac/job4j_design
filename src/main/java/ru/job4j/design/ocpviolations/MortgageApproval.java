package ru.job4j.design.ocpviolations;

public class MortgageApproval {

    public boolean approve(Borrower borrower) {
        return borrower.getSalary() > 50000 && borrower.getAge() < 55;
    }
}
