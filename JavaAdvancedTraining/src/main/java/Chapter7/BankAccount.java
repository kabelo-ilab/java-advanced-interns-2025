package Chapter7;

/**
 * @author Kabelo Tlhape
 * This class demonstrate different access levels
 * Public - Class members can be accessible outside the class
 * Private - Class members are only accessible within the class
 */

enum AccountType {
    DEBIT, SAVINGS,
    CREDIT, LOAN,
    CHEQUE
}
public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private AccountType accountType;
    private double balance;

    public BankAccount(String accNum, String accHolder, AccountType accType, double bal){
        setAccountHolder(accHolder);
        setAccountNumber(accNum);
        setAccountType(accType);
        setBalance(bal);
    }

    public void setBalance(double bal){
        this.balance = bal;
    }
    public double getBalance(){
        return this.balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    private void setAccountNumber(String accNum) {
        this.accountNumber = "ME-" + accNum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountHolder(String accHolder){
        if (accHolder.length() < 4){
            System.err.println("Account Holder should be at least 4 characters long");
        }else{
            this.accountHolder = accHolder;
        }
    }
    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance -= amount;
    }

    public void transfer(BankAccount targetAcc, double amount){
        this.withdraw(amount);
        targetAcc.deposit(amount);
    }
    public void displayDetails(){
        System.out.println("\nAccount Holder: " + getAccountHolder() + " (" + getAccountNumber() + ")");
        System.out.println("Account Type: " + getAccountType().name());
        System.out.println("Balance: " + getBalance());
    }
}
