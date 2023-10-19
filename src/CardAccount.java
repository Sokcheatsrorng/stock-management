import java.math.BigDecimal;
public class CardAccount {
    Integer id;
    String actNo;
    String actName;
    BigDecimal balance;
    Integer pin;
    BigDecimal limit;
    void checkBalance() {
        System.out.println("----- Check Balance -----");
        System.out.println("Account Id: "+ this.id);
        System.out.println("Account No: " + this.actNo);
        System.out.println("Account Name: " + this.actName);
        System.out.println("Balance ($): " + this.balance);
    }
    void deposit(BigDecimal amount) {
        int balanceLimit = amount.compareTo(limit);
        if(balanceLimit > 0){
            System.out.println("Invalid...");
        }
        else{
            balance = balance.add(amount);
        }
    }
    public void withdrawal(BigDecimal withdrawalAmount )
    {
        int amountComparison = withdrawalAmount.compareTo(limit);
        if(amountComparison > 0){
            System.out.println("Invailed...");
        }
        else{
            balance = balance.subtract(withdrawalAmount);
        }
    }

}


