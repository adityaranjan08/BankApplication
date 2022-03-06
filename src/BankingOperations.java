import java.time.LocalDate;
import java.util.Date;

public interface BankingOperations {
    boolean checkAge(LocalDate dob);
    String openAccount(String name, LocalDate dob, float amount);
    boolean depositAmount(float amount);
    float viewBalance();

}
