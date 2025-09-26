package Chapter9;

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
        setAccountType(accType);
        setAccountHolder(accHolder);
        setAccountNumber(accNum);
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

    /**
     * Set the account number with a prefix based on the {@code AccountType}
     * The prefix is set as follows: (DEBIT = DB, SAVINGS = SV, LOAN = LN, CHEQUE = CQ, CREDIT = CR)
     * @param accNum Account number
     */
    private void setAccountNumber(String accNum) {
        String accPrefix;
        if (getAccountType() == AccountType.DEBIT){
            accPrefix = "DB-";
        } else if (getAccountType() == AccountType.CHEQUE) {
            accPrefix = "CQ-";
        }else if (getAccountType() == AccountType.LOAN) {
            accPrefix = "LN-";
        }else if (getAccountType() == AccountType.CREDIT) {
            accPrefix = "CR-";
        }else {
            accPrefix = "SV-";
        }
        this.accountNumber = accPrefix + accNum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountHolder(String accHolder){
        if (accHolder.length() < 4){
            throw new IllegalArgumentException("Account Holder should be at least 4 characters long");
        }
        this.accountHolder = accHolder;

    }
    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void deposit(double amount){

        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount > getBalance()){
            throw new InsufficientFundsException("Insufficient Funds..." +
                    "\nCurrent Balance: " + getBalance() + "\n" +
                    "Requested Amount: " + amount);
        }
        this.balance -= amount;
    }

    public void transfer(BankAccount targetAcc, double amount) throws InsufficientFundsException{
        this.withdraw(amount);
        targetAcc.deposit(amount);
    }
    public String displayDetails(){
        return "\nAccount Holder: " + getAccountHolder() + " (" + getAccountNumber() + ")" +
                "\nAccount Type: " + getAccountType().name() +
                "\nBalance: " + getBalance();
    }
}
