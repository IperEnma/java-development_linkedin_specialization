public class BankAccount {

    String name;
    String password;
    double money;
    TypeAccount typeAccount;

    public BankAccount(String name, String password, double money, TypeAccount typeAccount) {
        this.name = name;
        this.password = password;
        this.money = money;
        this.typeAccount = typeAccount;
    }

    public void insertMoney(double money) {
        this.money = this.money + money;
    }

    public void withdrawMoney(double money) {
        if (this.money - money >= 0) {
            this.money = this.money - money;
        }
        else {
            throw new IllegalArgumentException("no money sufficient");
        }
    }

    boolean checkPassword(String password) {
        if (password.equals(this.password)) {
            return true;
        }
        return false;
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
