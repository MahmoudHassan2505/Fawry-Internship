import java.util.Scanner;

public class BankApplication {
    private static Bank b1 =new Bank();

    public static void main(String[] args) {
        System.out.println("Welcome!");
        boolean run =true;
        while(run){
            System.out.println("\n---------------------------------");
            System.out.println("\nplease select an option");
            System.out.println("---------------------------------");
            System.out.println("1 to Add new account");
            System.out.println("2 to Deposit Money");
            System.out.println("3 to Withdraw Money");
            System.out.println("4 Display Balance");
            System.out.println("To exit Enter any Number");

            Scanner scan =new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    registerAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    displayBalance();
                    break;
                default:
                    run=false;
                    break;

            }
        }

    }

    public static void registerAccount(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Account Name: ");
        String accName=scan.nextLine();

        System.out.println("\nEnter Balance: ");
        float accBalance = scan.nextFloat();


        b1.addAccount(accName,accBalance);

    }
    public static void depositMoney(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNumber = scan.nextLine();

        System.out.println("\nEnter Amount: ");
        float amount = scan.nextFloat();

        b1.deposit(accNumber,amount);
    }

    public static void withdrawMoney(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNumber = scan.nextLine();

        System.out.println("\nEnter Amount: ");
        float amount = scan.nextFloat();


        b1.withdraw(accNumber,amount);
    }

    public static void displayBalance(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNumber = scan.nextLine();

        System.out.print("Balance: " + b1.findAccount(accNumber).getAccountBalance());

    }
}
