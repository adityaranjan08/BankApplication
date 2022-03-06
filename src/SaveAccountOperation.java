public interface SaveAccountOperation extends BankingOperations{
    float calculateInterest();
    boolean withdraw(int amount);
}
