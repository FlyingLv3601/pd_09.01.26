import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double balance = 0.0;

        System.out.println("Internetbanka!");

        while (true) {
            System.out.print("\nIzvēlies darbību \n1 => pievienot\n2 => izņemt\n3 => balanss\n4 => iziet\n ");
            String cmd = sc.nextLine();

            if (cmd.equals("4")) {
                break;
            }

            switch (cmd) {
                case "1":
                    System.out.print("\nIevadiet pievienojamo summu: ");
                    add(balance, sc);
                    break;
                case "2":
                    System.out.print("\nIevadiet izņemto summu: ");
                    withdraw(balance, sc);
                    break;
                case "3":
                    System.out.print("Konta balanss: " + balance);
                    break;
                case "4":
                    System.out.print("Visu labu!");
                    break;
                default:
                    System.out.print("Nederīga komanda!");
            }
        }
    }

    public static double add(double balance, Scanner sc) {
        double dep = Double.parseDouble(sc.nextLine());
        if (dep < 0) {
            System.out.println("\nSummai jābūt pozitīvai");
        } else {
            balance += dep;
        }
        return balance;
    }

    public static double withdraw(double balance, Scanner sc) {
        double wit = Double.parseDouble(sc.nextLine());
        if (wit < 0) {
            System.out.println("\nSummai jābūt pozitīvai");
        } else if (wit > balance) {
            System.out.println("\nNepietiekami līdzekļi");
        } else {
            balance -= wit;
        }
        return balance;
    }
}
