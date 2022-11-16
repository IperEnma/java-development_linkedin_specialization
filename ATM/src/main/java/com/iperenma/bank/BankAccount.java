package com.iperenma.bank;

import java.util.ArrayList;

public abstract class BankAccount implements Agreements {

    protected String name;
    private final String password;
    protected double money;
    protected TypeAccount typeAccount;
    protected final ArrayList<String> movements = new ArrayList<>();

    public BankAccount(String name, String password, double money) {
        this.name = name;
        this.password = password;
        this.typeAccount = typeAccount;
        this.insertMoney(money);
    }

    public void insertMoney(double money) {
        this.money = this.money + money;
        String movement = "Deposit of " + String.format("%.2f", money) + " dollars";
        movements.add(movement);
    }

    public abstract void withdrawMoney(double money);

    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public String printData() {
        String data;
        if (this.typeAccount.equals(TypeAccount.CURRENT_ACCOUNT)) {
            data =  "Owner: " + this.name + "\nMoney: " + this.money + "\nType account: Current";
        }
        else {
            data =  "Owner: " + this.name + "\nMoney: " + this.money + "\nType account: Savings";
        }
        return data;
    }

    public ArrayList<String> getMovements(int numbersMovements) {
        ArrayList<String> response = new ArrayList<>();
        for (int i = 0; i < numbersMovements && i < movements.size(); i++) {
            response.add(movements.get(i));
        }
        return response;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", typeAccount=" + typeAccount +
                '}';
    }
}
