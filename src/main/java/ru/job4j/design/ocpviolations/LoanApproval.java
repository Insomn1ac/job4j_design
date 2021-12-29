package ru.job4j.design.ocpviolations;

public class LoanApproval {

    public void approveMortgage(MortgageApproval approval, Borrower borrower) {
        if (approval.approve(borrower)) {
            System.out.println("approved");
        } else {
            System.out.println("doesn't approved");
        }
    }

    public void approveMicroCredit(MicroCreditApproval approval, Borrower borrower) {
        if (approval.approve(borrower)) {
            System.out.println("approved");
        } else {
            System.out.println("doesn't approved");
        }
    }
}

