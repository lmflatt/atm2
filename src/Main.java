
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        String name = new String();
        Bank.createProfile();

        boolean a = true;
        while(a) {

            boolean b = true;
            while (b) {
                boolean c = true;
                while (c) {
                    c = Bank.createAnotherProfile();
                }

                name = Validation.isValidUser();
                if (!(name.equalsIgnoreCase("escape")))
                    b = false;
            }

            boolean d = true;
            while (d) {
                String choice = Bank.chooseTransaction();

                if (choice.equalsIgnoreCase("1")) {
                    Transactions.checkBalance(name);
                    d = Transactions.loopTransaction();
                } else if (choice.equalsIgnoreCase("2")) {
                    Transactions.withdrawMoney(name);
                    d = Transactions.loopTransaction();
                } else if (choice.equalsIgnoreCase("3")) {
                    d = false;
                }
            }
        }



    }
}
