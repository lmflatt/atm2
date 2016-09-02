import java.util.DoubleSummaryStatistics;
import java.util.HashMap;

/**
 * Created by lee on 8/31/16.
 */

public class Validation {

    public static String validateString(String s) {

        if (s.length() == 0)
            System.out.println("Invalid, Entry cannot be left blank.");

        return s;
    }


    public static Double validatePositiveDouble(String d) {
        String s = new String("");

        for (char c : d.toCharArray()) {
            if (Character.isDigit(c)) {
                s += c;
            } else if (c == '.' && !(s.contains("."))) {
                s += c;
            }
        }

        Double validDouble = Double.parseDouble(s);
        return validDouble;
    }

    public static Integer validatePrimInt(String i) {
        String s = new String("");

        for (char c : i.toCharArray()) {
            if (Character.isDigit(c)) {
                s += c;
            } else if (c == '.') {
                break;
            }
        }

        Integer validInt = Integer.parseInt(s);
        return validInt;
    }

    public  static String isValidUser() {
        boolean a = true;
        String name = new String();

        while (a) {
            try {
                System.out.println();
                System.out.println("Welcome to Java Bank!");
                System.out.println("Please Enter your name to access your account.");
                name = Main.scanner.nextLine();
                if (Bank.bankRecords.containsKey(name)) {
                    System.out.println();
                    System.out.println("Welcome " + name + "!");
                    a = false;
                }
                else if (name.equalsIgnoreCase("escape")) {
                    a = false;
                }
                else {
                    System.out.println();
                    System.out.println("Invalid User. Re-Enter name or Enter [escape] to exit to Account Creation.");
                }
            } catch (Exception e) {
                System.out.println("Please Enter a valid name.");
            }
        }

        return name;
    }

}
