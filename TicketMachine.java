public class TicketMachine {
    private double price;
    private double balance;
    private double total;

    /**
     * Creates a ticket machine with the given ticket price.
     */
    public TicketMachine(double ticketCost) {
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     * Returns the total value of tickets sold.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Returns the price of a ticket.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the amount of money currently inserted.
     */
    public double getAmount() {
        return balance;
    }

    /**
     * Returns the amount of money currently inserted.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Receives money from the customer.
     */
    public void insertMoney(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    /**
     * Displays a prompt asking the customer to insert money.
     */
    public void prompt() {
        System.out.println("Please insert the correct amount of money.");
    }

    /**
     * Displays the price of a ticket.
     */
    public void showPrice() {
        System.out.println("The price of a ticket is " + formatMoney(price) + ".");
    }

    /**
     * Prints a ticket and updates the machine state.
     */
    public void printTicket() {
        System.out.println("##################");
        System.out.println("# Ticket");
        System.out.println("# " + formatMoney(price));
        System.out.println("##################");
        System.out.println();

        total = total + price;
        balance = balance - price;
    }

    /**
     * Empties the machine and returns the amount collected.
     */
    public double emptyMachine() {
        double collected = total;
        total = 0;
        balance = 0;
        return collected;
    }

    public static String formatMoney(double value) {
        return String.format("%.2f", value);
    }
}
