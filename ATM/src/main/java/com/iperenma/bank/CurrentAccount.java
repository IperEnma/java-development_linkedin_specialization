package com.iperenma.bank;

public class CurrentAccount extends BankAccount {

    private static final double COMISION = 5;
    public CurrentAccount(String name, String password, double money) {
        super(name, password, money);
        this.typeAccount = TypeAccount.CURRENT_ACCOUNT;
    }

    @Override
    public void withdrawMoney(double money) {
        if (this.money - (money + COMISION) >= 0) {
            this.money = this.money - (money - COMISION);
            String movement = "Withdraw of " + String.format("%.2f", money) + " dollars";
            movements.add(movement);
        }
        else {
            throw new IllegalArgumentException("no money sufficient");
        }
    }

    @Override
    public void showAgree() {
        System.out.println("agreements...");
    }
}
