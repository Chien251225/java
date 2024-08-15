package demo;

/**
 * This is a class for the behavior of a Person
 * @author Student name
 * @version 1.0
 */
public class Person {

    /**
     * The person's Wallet
     */
    private Wallet wallet;

    /**
     * Constructor to initialize the Person with an initial amount in the wallet
     * @param initialAmount Initial amount in the wallet
     */
    public Person(int initialAmount) {
        this.wallet = new Wallet(initialAmount);
    }

    /**
     * The method to calculate the total bill
     * @param bills Array of bills
     * @return total value of all bills
     */
    public int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }

    /**
     * The method for the user to pay money
     * @param total The total value of all bills
     * @return pay status (true if payment was successful, false otherwise)
     */
    public boolean payMoney(int total) {
        if (wallet.acceptMoney(total)) {
            // Deduct the total from the wallet if there's enough money
            wallet.setMoneyAmount(wallet.getAmount() - total);
            return true;
        }
        return false;
    }

    /**
     * This is a nested class for the person's Wallet
     */
    protected class Wallet {
        /**
         * Money in the wallet
         */
        private int amount;

        /**
         * Constructor to initialize the Wallet with an initial amount
         * @param initialAmount Initial amount in the wallet
         */
        public Wallet(int initialAmount) {
            this.amount = initialAmount;
        }

        /**
         * Method to set the amount of money in the wallet
         * @param amount New amount of money in the wallet
         * @return status (true if the amount was set successfully, false otherwise)
         */
        public boolean setMoneyAmount(int amount) {
            if (amount >= 0) {
                this.amount = amount;
                return true;
            }
            return false;
        }

        /**
         * Method to get the current amount of money in the wallet
         * @return Current amount of money
         */
        public int getAmount() {
            return amount;
        }

        /**
         * Method to check if the wallet has enough money to pay
         * @param total Total amount to be paid
         * @return pay status (true if the wallet has enough money, false otherwise)
         */
        public boolean acceptMoney(int total) {
            return this.amount >= total;
        }
    }
}

