import java.util.Scanner;

public class atmMachine{
    private static double balance = 10000.0; // Starting balance
    private static final int PIN = 1234; // Dummy pin

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Simple ATM!");

        // PIN check
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Successfully deposited ₹" + depositAmount);
                    } else {
                        System.out.println("Enter a valid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("Please collect your cash: ₹" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
