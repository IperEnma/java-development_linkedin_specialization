import java.util.ArrayList;

public class BankAccount {

    String name;
    String password;
    double money;
    TypeAccount typeAccount;
    ArrayList<String> movements = new ArrayList<>();

    public BankAccount(String name, String password, double money, TypeAccount typeAccount) {
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

    public void withdrawMoney(double money) {
        if (this.money - money >= 0) {
            this.money = this.money - money;
            String movement = "Withdraw of " + String.format("%.2f", money) + " dollars";
            movements.add(movement);
        }
        else {
            throw new IllegalArgumentException("no money sufficient");
        }
    }

    boolean checkPassword(String password) {
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
