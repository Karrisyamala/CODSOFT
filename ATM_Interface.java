import java.util.Scanner;

class ATM_INTERFACE {
    private double balance;

    public ATM_INTERFACE(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of " + amount + " successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Unable to withdraw " + amount);
        }
    }
}

class ATMMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM_INTERFACE bankAccount = new ATM_INTERFACE(1000); // Initial balance of 1000
        ATM_INTERFACE atm = bankAccount; // Corrected change

        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to ATM MACHINE");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    double balance = atm.getBalance();
                    System.out.println("Current balance: " + balance);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you");
            }
        }
    }
}