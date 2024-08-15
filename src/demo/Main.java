import demo.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Shopping program ========");
        System.out.print("Input number of bills: ");
        int numBills = scanner.nextInt();

        int[] bills = new int[numBills];
        for (int i = 0; i < numBills; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = scanner.nextInt();
        }

        System.out.print("Input value of wallet: ");
        int walletAmount = scanner.nextInt();

        Person person = new Person(walletAmount);

        int totalAmount = person.calcTotal(bills);

        System.out.println("======= Shopping program ========");
        System.out.println("This is total of bills: " + totalAmount);

        if (person.payMoney(totalAmount)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }

        scanner.close();
    }
}
