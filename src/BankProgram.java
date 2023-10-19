import java.math.BigDecimal;
import java.util.Scanner;

public class BankProgram {
    static SavingAccount[] savingAccounts;
    static CardAccount[] cardAccounts;
    static Scanner scanner;
    static void initSavingAccount() {
        scanner = new Scanner(System.in);
        savingAccounts = new SavingAccount[3];
        SavingAccount sa1 = new SavingAccount();
        sa1.id = 1;
        sa1.actName = "KHEM";
        sa1.actNo = "000-000-001";
        sa1.balance = BigDecimal.valueOf(100);
        sa1.pin = 1234;
        sa1.interestRate = 10F;
        savingAccounts[0] = sa1;

        SavingAccount sa2 = new SavingAccount();
        sa2.id = 2;
        sa2.actName = "PERKMI";
        sa2.actNo = "000-000-002";
        sa2.balance = BigDecimal.valueOf(100);
        sa2.pin = 1234;
        sa2.interestRate = 10F;
        savingAccounts[1] = sa2;

        SavingAccount sa3 = new SavingAccount();
        sa3.id = 3;
        sa3.actName = "TEMO";
        sa3.actNo = "000-000-003";
        sa3.balance = BigDecimal.valueOf(100);
        sa3.pin = 1234;
        sa3.interestRate = 10F;
        savingAccounts[2] = sa3;
    }
    static void initCardAccount() {
        scanner = new Scanner(System.in);
        cardAccounts = new CardAccount[3];
        CardAccount ca1 = new CardAccount();
        ca1.id = 1;
        ca1.actName = "KHEM";
        ca1.actNo = "000-000-001";
        ca1.balance = BigDecimal.valueOf(100);
        ca1.pin = 1234;
        ca1.limit = BigDecimal.valueOf(100);
        cardAccounts[0] = ca1;

        CardAccount ca2 = new CardAccount();
        ca2.id = 2;
        ca2.actName = "PHEKMI";
        ca2.actNo = "000-000-002";
        ca2.balance = BigDecimal.valueOf(100);
        ca2.pin = 1234;
        ca2.limit = BigDecimal.valueOf(100);
        cardAccounts[1] = ca2;

        CardAccount ca3 = new CardAccount();
        ca3.id = 3;
        ca3.actName = "TEMO";
        ca3.actNo = "000-000-003";
        ca3.balance = BigDecimal.valueOf(100);
        ca3.pin = 1234;
        ca3.limit = BigDecimal.valueOf(100);
        cardAccounts[2] = ca3;
    }

    static void chooseAccount(){
        System.out.println("1. SavingAccount");
        System.out.println("2. CardAccount");
        System.out.println("3. Close");
        System.out.print("Please Choose your Account : ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("---------------Choose Account-------------------------");
            chooseAccount();
            boolean isContinue = true;
            int chooseAct = Integer.parseInt(scanner.nextLine());
            switch (chooseAct){
                case 1 -> {
                    initSavingAccount();
                    do {
                        showMenu();
                        int menu = Integer.parseInt(scanner.nextLine());
                        switch (menu) {
                            case 1 -> {
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                SavingAccount foundAccount = findSavingAccount(actNo, pin);
                                if (foundAccount != null) {
                                    foundAccount.checkBalance();
                                } else {
                                    System.out.println("Invalid Account..!");
                                }
                                CommonUtil.enter10Lines();
                            }
                            case 2 -> {
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                SavingAccount foundAccount = findSavingAccount(actNo, pin);

                                if (foundAccount != null) {
                                    System.out.print("Enter amount to deposit: ");
                                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                                    foundAccount.deposit(amount);
                                } else {
                                    System.out.println("Invalid Account..!");
                                }

                            }
                            case 3 -> {
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                SavingAccount foundAccount = findSavingAccount(actNo, pin);
                                if (foundAccount != null) {
                                    System.out.print("Enter amount to withdrawal: ");
                                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                                    foundAccount.withdrawal(amount);
                                } else {
                                    System.out.println("Invalid Account..!");
                                }
                            }
                            default ->
                                throw new IllegalStateException("Invalid Menu");
                        }
                        isContinue = false;
                    } while (isContinue);
                }
                case 2->{
                    initCardAccount();
                    do{

                        showMenu();
                        int menu = Integer.parseInt(scanner.nextLine());
                        switch (menu){
                            case 1->{

                                System.out.print("Enter id : ");
                                Integer id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                CardAccount foundCardAccount = findCardAccount(id,actNo,pin);
                                if (foundCardAccount != null) {
                                    foundCardAccount.checkBalance();
                                } else {
                                    System.out.println("Invalid Account..!");
                                }
                                CommonUtil.enter10Lines();
                            }
                            case 2->{
                                System.out.print("Enter id : ");
                                Integer id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                CardAccount foundCardAccount = findCardAccount(id,actNo,pin);

                                if (foundCardAccount != null) {
                                    System.out.print("Enter amount to deposit: ");
                                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                                    foundCardAccount.deposit(amount);
                                } else {
                                    System.out.println("Invalid Account..!");
                                }
                            }
                            case 3->{
                                System.out.print("Enter id : ");
                                Integer id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter Account No: ");
                                String actNo = scanner.nextLine();
                                System.out.print("Enter Pin: ");
                                Integer pin = Integer.parseInt(scanner.nextLine());
                                CardAccount foundCardAccount = findCardAccount(id,actNo,pin);
                                if (foundCardAccount != null) {
                                    System.out.print("Enter amount to withdrawal: ");
                                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                                    foundCardAccount.withdrawal(amount);
                                } else {
                                    System.out.println("Invalid Account..!");
                                }

                            }
                            default -> System.out.println("Invalid CardAccount Menu...");
                        }

                    }while(isContinue);
                }
                default ->
                    throw new IllegalStateException("Close");

            }
        }while(true);
    }

    static void showMenu() {
        System.out.println("Welcome to my Bank Program");
        System.out.println("-".repeat(20));
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.print("Choose menu (1-3): ");
    }
    static SavingAccount findSavingAccount(String actNo, Integer pin) {

        for (SavingAccount sa : savingAccounts) {
            if (sa.actNo.equals(actNo)) {
                if (sa.pin.equals(pin)) {
                    return sa;
                }
            }
        }
        return null;
    }
    static CardAccount findCardAccount(Integer id, String actNo, Integer pin)
    {
        for (CardAccount ca: cardAccounts) {
            if (ca.id.equals(id)) {
                if (ca.actNo.equals(actNo)) {
                    if (ca.pin.equals(pin)) {
                        return ca;
                    }
                }
            }
        }
        return null;
    }
}
