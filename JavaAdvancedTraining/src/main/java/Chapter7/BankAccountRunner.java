package Chapter7;

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount objBank = new BankAccount("123456789", "Joe Smith", AccountType.SAVINGS, 5000);
        BankAccount objDebit = new BankAccount("987456321", "Joe Smith", AccountType.DEBIT, 800);

        objBank.transfer(objDebit,1000);

        objBank.deposit(3000);
        objDebit.displayDetails();

        objBank.withdraw(1000);
        objBank.displayDetails();
        System.out.println("\nCurrent balance for (" + objBank.getAccountNumber() + ") is: "
                + objBank.getBalance());

        System.out.println("\nCurrent balance for (" + objDebit.getAccountNumber() + ") is: "
                + objDebit.getBalance());


    }
}
