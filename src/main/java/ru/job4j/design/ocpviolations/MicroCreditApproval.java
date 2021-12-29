package ru.job4j.design.ocpviolations;

public class MicroCreditApproval {

    public boolean approve(Borrower borrower) {
        return !borrower.isWanted();
    }
}
