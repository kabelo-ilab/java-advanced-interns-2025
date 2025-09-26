package Chapter9;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    static BankAccount objAccount;

    @BeforeEach
    void setup(){
        objAccount = new BankAccount("123456","Joe Smith", AccountType.CHEQUE, 10000);
    }

    @AfterEach
    void getCurrentAccountData(){
        System.err.println(objAccount.displayDetails());
    }

    @Test
    @DisplayName("Test Account Holder - Invalid name")
    void testInvalidAccountHolder(){
        assertThrows(IllegalArgumentException.class,
                () -> objAccount.setAccountHolder("Joe"));
    }

    @Test
    @DisplayName("Test Account Deposit")
    void testDeposit(){
        //Arrange
        double amountToDeposit = 2000;
        double expectedBalance = 12000;
        //Actual
        objAccount.deposit(amountToDeposit);
        double actualBalance = objAccount.getBalance();
        //Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test withdrawal")
    void testWithdrawal(){
        //Arrange
        double amountToWithdraw = 1000;
        double expectedBalance = 9000;
        //Actual
        double actualBalance = 0;
        try {
            objAccount.withdraw(amountToWithdraw);
            actualBalance = objAccount.getBalance();
            //Assert
            assertEquals(expectedBalance, actualBalance);
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
    }
    @Test
    @DisplayName("Test Withdrawal - Insufficient Funds")
    void testWithdrawalInsufficientFunds(){
        double amountToWithdraw = 12000;

        assertThrows(InsufficientFundsException.class,
                () -> objAccount.withdraw(amountToWithdraw));
    }

    @Test
    @DisplayName("Transfer: from current account to target account")
    void testTransfer(){
        BankAccount objDebit = new BankAccount("654321","Joe Smith", AccountType.DEBIT, 5000);
        double amountToTransfer = 2000;
        double expectedCurrentBalance = 8000;
        double expectedTargetBalance = 7000;

        try {
        //Actual
            objAccount.transfer(objDebit,amountToTransfer);
            double actualCurrentBal = objAccount.getBalance();
            double actualTargetBal = objDebit.getBalance();

            assertAll(
                    () -> assertEquals(expectedTargetBalance, actualTargetBal),
                    () -> assertEquals(expectedCurrentBalance, actualCurrentBal)
            );
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void testAccountNumberPrefix(){
        String accountNumber = "123456";
        String accountHolder = "John Smith";
        double balance = 5000;

        BankAccount objLoan = new BankAccount(accountNumber,accountHolder,AccountType.LOAN,balance);
        BankAccount objDebit = new BankAccount(accountNumber,accountHolder,AccountType.DEBIT,balance);
        BankAccount objCheque = new BankAccount(accountNumber,accountHolder,AccountType.CHEQUE,balance);
        BankAccount objCredit = new BankAccount(accountNumber,accountHolder,AccountType.CREDIT,balance);
        BankAccount objSavings = new BankAccount(accountNumber,accountHolder,AccountType.SAVINGS,balance);

        assertAll(
                () -> assertEquals("LN-" + accountNumber, objLoan.getAccountNumber()),
                () -> assertEquals("DB-" + accountNumber, objDebit.getAccountNumber()),
                () -> assertEquals("CQ-" + accountNumber, objCheque.getAccountNumber()),
                () -> assertEquals("CR-" + accountNumber, objCredit.getAccountNumber()),
                () -> assertEquals("SV-" + accountNumber, objSavings.getAccountNumber())
        );
    }
}
