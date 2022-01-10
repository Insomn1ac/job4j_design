package ru.job4j.design.lspviolations;

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void transaction(int money) {
        if (this.money <= 10) {
            throw new IllegalArgumentException("Incorrect amount of money! Must be more than 10");
        }
        this.money -= money;
    }
}

class SomeUserAccount extends BankAccount {

    public SomeUserAccount(int money) {
        super(money);
    }

    @Override
    public void transaction(int money) {
        if (getMoney() <= 100) {
            throw new IllegalArgumentException("Incorrect amount of money! Must be more than 100");
        }
        setMoney(getMoney() - money);
    }
}

class Logic {
    public static void main(String[] args) {
        BankAccount incorrect = new SomeUserAccount(13);
        BankAccount correct = new BankAccount(13);
        incorrect.transaction(5);
        correct.transaction(5);
        System.out.println("Incorrect account - " + incorrect.getMoney()
                + ", Correct account - " + correct.getMoney());
    }
}


