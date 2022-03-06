import java.time.LocalDate;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********Welcome to IDBC net banking********\nSelect Account type\n1)PayAccount\n2)Saving account");
        int accountType = scanner.nextInt();
        scanner.nextLine();
        System.out.println("******Lets open your account!******\nEnter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your DOB in format YYYY-MM-DD");
        String dob = scanner.nextLine();
        System.out.println("Enter the base amount");
        int amount = scanner.nextInt();
        boolean flag = true;
        switch (accountType) {
            case 1 -> {
                PayAccountOperationImpl payAccount = new PayAccountOperationImpl();
                System.out.println((payAccount.openAccount(name, LocalDate.parse(dob), amount)));
                while (flag) {
                    System.out.println("We have following services for PayAccount.\n1)Deposit Amount\n2)Check Balance\n3)Fund Transfer\nOr..Press any key to exit");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the amount to deposit");
                            int depositAmount = scanner.nextInt();
                            payAccount.depositAmount(depositAmount);
                        }
                        case 2 -> System.out.println("Your balance is " + payAccount.viewBalance());
                        case 3 -> {
                            System.out.println("Enter the beneficiary 12-digit account no.");
                            scanner.nextLine();
                            String beneficiary = scanner.nextLine();
                            System.out.println("Enter the beneficiary name");
                            String beneficiaryName = scanner.nextLine();
                            System.out.println("Enter the amount to transfer");
                            int transfer = scanner.nextInt();
                            payAccount.fundTransfer(transfer, new Account(beneficiary, beneficiaryName, LocalDate.now(), 0, AccountType.PAYACCOUNT));
                        }
                        default -> flag = false;
                    }
                }
            }
            case 2 -> {
                SaveAccountOperationImpl savingAccount = new SaveAccountOperationImpl();
                System.out.println((savingAccount.openAccount(name, LocalDate.parse(dob), amount)));
                while (flag) {
                    System.out.println("We have following services for Savings account.\n1)Deposit Amount\n2)Check Balance\n3)Calculate Interest\n4)Withdraw\nOr..Press any key to exit");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the amount to deposit");
                            int depositAmount = scanner.nextInt();
                            savingAccount.depositAmount(depositAmount);
                            break;

                        case 2:
                            System.out.println("Your balance is : " + savingAccount.viewBalance());
                            break;
                        case 3:
                            System.out.println("Your Interest is : " + savingAccount.calculateInterest());
                            break;
                        case 4:
                            System.out.println("Enter the amount to withdraw");
                            int withdrawAmount = scanner.nextInt();
                            savingAccount.withdraw(withdrawAmount);
                            break;
                        default:
                            flag = false;
                    }
                }
            }
        }
    }
        }
