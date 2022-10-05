import java.util.*;

class BankAccount {
    static Scanner input = new Scanner(System.in);
    String name;
    static String actype;
    int accNo;
    int bal;
    int amt;
    static int bal0;

    BankAccount(String name, int accNo, String actype, int bal) {
        this.name = name;
        this.accNo = accNo;
        this.actype = actype;
        this.bal = bal;
    }

    int deposit() {
        System.out.print("Enter amount to deposit:");
        amt = input.nextInt();
        if (amt < 0) {
            System.out.println("Invalid Amount");
            return 1;
        }
        bal = bal + amt;
        return 0;
    }

    int withdraw() {
        System.out.println("*--------------------*");
        System.out.println("Your Balance=" + bal);
        System.out.print("Enter amount to withdraw:");
        amt = input.nextInt();
        if (bal < amt) {
            System.out.println("Not sufficient balance.");
            System.out.println("*----------------------*");

            return 1;
        }
        if (amt < 0) {
            System.out.println("Invalid Amount");
            System.out.println("*-------------*");
            return 1;
        }
        bal = bal - amt;
        return 0;
    }

    int applyCredit() {
        System.out.println("*-----------------------*");
        System.out.println("please enter credit score");
        int credit = input.nextInt();
        if (credit >= 650) {
            System.out.println("Congratulations you have qualified for credit.");
            System.out.println("Please enter desired credit amount: ");
            int loan = input.nextInt();
            bal0 = bal + loan;
            return 1;
            }
        else if(credit < 650){
            System.out.println("Unfortunately we are not currently offering loans to people with scores under 650");
            System.out.println("*--------------------------------------------------------------------------------*\n");

        }
        return credit;
    }


    void display() {
        System.out.println("Name:" + name);
        System.out.println("Account No:" + accNo);
        System.out.println("Balance:" + bal);

    }

    void dbal() {
        System.out.println("Balance:" + bal);
    }

    public static void main(String args[]) {

        System.out.println("Hello, welcome to Soren's bank. All information is stored and can be accessed at any point");
        System.out.println("Enter your Name: ");
        String nn = input.nextLine();
        System.out.println("Create an Account Number: ");
        int num = input.nextInt();
        System.out.println("Enter Account Type (Saving, Checking, Other: ");
        String type = input.next();
        System.out.println("Enter Initial Balance: ");
        int bal = input.nextInt();
        BankAccount b1 = new BankAccount(nn, num, type, bal);
        int menu;
        System.out.println("Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.println("5. Apply for credit");
        boolean quit = false;
        do {
            System.out.print("Please enter your choice: ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    b1.deposit();
                    break;

                case 2:
                    b1.withdraw();
                    break;

                case 3:
                    b1.display();
                    break;

                case 4:
                    quit = true;
                    break;

                case 5:
                    b1.applyCredit();
                    System.out.println(bal0);
                    break;

            }
        } while (!quit);
    }
}