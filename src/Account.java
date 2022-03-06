import java.time.LocalDate;
import java.util.Date;

public class Account {
    String accNo;
    String accName;
    LocalDate dateOfBirth;
    float balance;
    AccountType accountType;

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Account(String accNo, String accName, LocalDate dateOfBirth, float balance, AccountType accountType) {
        this.accNo = accNo;
        this.accName = accName;
        this.dateOfBirth = dateOfBirth;
        this.balance = balance;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", accName='" + accName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }



}
