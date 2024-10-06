class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void deposit(int[] amounts) {
        for (int amount : amounts) {
            balance += amount;
        }
    }

    public int withdraw(int amount) {
        if (balance < amount) {
            int withdrawn = balance;
            balance = 0;
            return withdrawn;
        } else {
            balance -= amount;
            return amount;
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account a = new Account(100);
        a.deposit(5000);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int wMoney = 1000;
        int money = a.withdraw(wMoney);
        if (wMoney > money) {
            System.out.println(money + "원만 인출");
        } else {
            System.out.println(money + "원 인출");
        }
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}
