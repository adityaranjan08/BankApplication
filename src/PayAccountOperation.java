public interface PayAccountOperation extends BankingOperations {
    boolean fundTransfer(float amount,Account accDetails);
}
