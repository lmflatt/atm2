import java.util.HashMap;

/**
 * Created by lee on 9/1/16.
 */
public class Bank {
    public static HashMap<String, Double> bankRecords = new HashMap<>();

    public static void createProfile() {
        String name = new String();
        Double balance = new Double(0.);
        boolean a = true;

        while(a) {
            try {
                System.out.println("Creating Account. Please Enter your name.");
                name = Validation.validateString(Main.scanner.nextLine());
                if (name.length() > 0 && !(name.equalsIgnoreCase("escape"))) {
                    a = false;
                }
                else {
                    System.out.println();
                    System.out.println("Please Enter a valid name.");
                }
            } catch (Exception e) {
                System.out.println("Please Enter a valid name.");
            }
        }

        while (balance == 0) {
            try {
                System.out.println("Please Enter your starting balance.");
                String balanceString = Main.scanner.nextLine();
                if (balanceString.matches(".*\\d+.*")) {
                    balance = Validation.validatePositiveDouble(balanceString);
                }
                else {
                    System.out.println();
                    System.out.println("Please Enter a valid number amount.");
                }
            } catch (Exception e) {
                System.out.println("Please Enter a valid amount.");
            }
        }

        bankRecords.put(name, balance);
        System.out.println("User " + name + " Created. Balance is set to $" + balance + ".");
    }

    public  static boolean createAnotherProfile() {
        boolean a = true;
        boolean b = true;

        while (b) {
            try {
                System.out.println("Enter [1] to Sign In or [2] to Create Another User.");
                String choiceString = Main.scanner.nextLine();
                if (choiceString.equalsIgnoreCase("1")) {
                    a = false;
                    b = false;
                }
                else if (choiceString.equalsIgnoreCase("2")) {
                    createProfile();
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

    public  static String chooseTransaction() {
        boolean b = true;
        String choice = new String();

        while (b) {
            try {
                System.out.println("Enter [1] to Check your Balance, [2] to Make a Withdrawal, or [3] to Cancel.");
                choice = Main.scanner.nextLine();
                if (choice.equalsIgnoreCase("1")) {
                    b = false;
                }
                else if (choice.equalsIgnoreCase("2")) {
                    b = false;
                }
                else if (choice.equalsIgnoreCase("3")) {
                    b = false;
                }
                else {
                    System.out.println();
                    System.out.println("Please Enter the number [1], [2], or [3].");
                }
            } catch (Exception e) {
                System.out.println("Please Enter a valid entry, the number [1], [2], or [3].");
            }
        }

        return choice;
    }
}
