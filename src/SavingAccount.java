import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingAccount {
    Integer id;
    String actNo;
    String actName;
    BigDecimal balance;
    Integer pin;
    Float interestRate;
    // processing deposit in BankAccount
    void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
    // processing withdrawal in BankAccount
    public void withdrawal(BigDecimal withdrawalAmount )
    {
        int amountComparison = withdrawalAmount.compareTo(balance);
        if(amountComparison>0){
            System.out.println("Invailed...");
        }
        else{
            balance = balance.subtract(withdrawalAmount);
        }
    }

    void checkBalance() {
        System.out.println("----- Check Balance -----");
        System.out.println("Account No: " + this.actNo);
        System.out.println("Account Name: " + this.actName);
        System.out.println("Balance ($): " + this.balance);
        System.out.println("Interest Rate (%): " + this.interestRate);
        System.out.println("Total Balance ($): " + this.getBalanceWithInterestRate());
    }

    BigDecimal getBalanceWithInterestRate() {

        BigDecimal rating = BigDecimal.valueOf(interestRate / 100);
        rating = rating.setScale(2, RoundingMode.FLOOR);
        BigDecimal ratingBalance = balance.multiply(rating);
        return balance.add(ratingBalance);
    }

}
