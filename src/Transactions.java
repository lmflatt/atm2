/**
 * Created by lee on 9/1/16.
 */
public class Transactions {

    public static void checkBalance(String s) {
        Double balance = Bank.bankRecords.get(s);
        System.out.println();
        System.out.println("Your current balance is: $" + balance + ".");
    }

    public static void withdrawMoney(String s) {
        Double balance = Bank.bankRecords.get(s);
        Double withdrawal = new Double(0);

        while (withdrawal == 0.) {
            try {
                System.out.println();
                System.out.println("Please Enter the amount you would like to withdraw");
                String withdrawalString = Main.scanner.nextLine();
                if (withdrawalString.matches(".*\\d+.*")) {
                    withdrawal = Validation.validatePositiveDouble(withdrawalString);
                    if (withdrawal < balance) {
                        balance -= withdrawal;
                        Bank.bankRecords.put(s, balance);
                        System.out.println();
                        System.out.println("Please remove cash. Your Balance is now: $" + balance + ".");
                    }
                    else {
                        System.out.println();
                        System.out.println("Insufficient Funds. Please Enter a lower amount.");
                        withdrawal = 0.;
                    }
                }
                else {
                    System.out.println();
                    System.out.println("Please enter a valid number amount.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    public static boolean loopTransaction() {
        boolean a = true;
        boolean b = true;

        while (b) {
            try {
                System.out.println();
                System.out.println("Enter [1] for Another Transaction or [2] to Exit.");
                String choiceString = Main.scanner.nextLine();
                if (choiceString.equalsIgnoreCase("1")) {
                    b = false;
                }
                else if (choiceString.equalsIgnoreCase("2")) {
                    a = false;
                    b = false;
                }
                else {
                    System.out.println();
                    System.out.println("Please Enter the number [1] or [2].");
                }
            } catch (Exception e) {
                System.out.println("Please Enter a valid entry, the number [1] or [2].");
            }
        }

        return a;
    }
}
