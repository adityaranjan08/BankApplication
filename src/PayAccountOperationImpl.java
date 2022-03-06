import java.time.LocalDate;
import java.util.Random;

public class PayAccountOperationImpl implements PayAccountOperation {
    Account account;
    @Override
    public boolean checkAge(LocalDate dob) {
        return ((LocalDate.now().getYear()-dob.getYear())>=18);
    }

    @Override
    public String openAccount(String name, LocalDate dob, float amount) {
        String msg = "Age less than 18, account cannot be opened.";
        Random random = new Random();
        long accountNo = new Random().nextLong(99999999);
        if(checkAge(dob)){
            this.account=new Account(("IDBC"+String.valueOf(accountNo)), name, dob, amount, AccountType.PAYACCOUNT);
            msg = "Account Opened\n"+account.toString();
        }
            return msg;
    }

    @Override
    public boolean depositAmount(float amount) {
        account.setBalance(account.balance+amount);
        System.out.println("*****Balance Updated*****\nNew balance = "+account.balance);
        return true;
    }

    @Override
    public float viewBalance() {
        return account.balance;
    }

    @Override
    public boolean fundTransfer(float amount, Account accDetails) {
        if(amount> account.balance)
            System.out.println("Insufficient balance : "+account.balance);
        else {
            account.setBalance(account.balance - amount);
            accDetails.setBalance(accDetails.balance+amount);
            System.out.println("Amount transferred to "+accDetails.toString());
        }
        return true;
    }
}
