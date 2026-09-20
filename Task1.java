public class Task1
{
    private int price;
    private int balance;
    private int total;

    /**
     * Constructor
     * Creates a ticket machine with the given ticket price.
     */
    public Task1(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     * Exercise 2.26
     * Accessor method that returns the total value of tickets sold.
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Returns the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Exercise 2.5
     * Accessor can be named getAmount instead of getBalance.
     */
    public int getAmount()
    {
        return balance;
    }

    /**
     * Returns the amount of money currently inserted.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receives money from the customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Exercise 2.37
     * Displays a prompt asking the customer to insert money.
     */
    public void prompt()
    {
        System.out.println("Please insert the correct amount of money.");
    }

    /**
     * Exercise 2.41
     * Displays the price of a ticket.
     */
    public void showPrice()
    {
        System.out.println("The price of a ticket is " + price + " cents.");
    }

    /**
     * Prints a ticket.
     */
    public void printTicket()
    {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        total = total + price;
        balance = balance - price;
    }

    /**
     * Main method for testing all exercises.
     */
    public static void main(String[] args)
    {
        System.out.println("========================================");
        System.out.println("       TICKET MACHINE LAB");
        System.out.println("========================================");

        System.out.println("\n--- Exercise 1 ---");

        Task1 machine = new Task1(500);

        System.out.println("Ticket price: " + machine.getPrice());
        System.out.println("Initial balance: " + machine.getBalance());

        machine.insertMoney(200);

        System.out.println("Balance after inserting 200 cents: "
                           + machine.getBalance());

        machine.insertMoney(300);

        System.out.println("Balance after inserting another 300 cents: "
                           + machine.getBalance());

        System.out.println("\nPrinting ticket:");
        machine.printTicket();

        System.out.println("--- Exercise 2.1 ---");

        System.out.println("Balance after printing ticket: "
                           + machine.getBalance());

        System.out.println("\n--- Exercise 2.2: Too Much Money ---");

        Task1 machineTooMuch = new Task1(500);

        machineTooMuch.insertMoney(800);

        System.out.println("Ticket price: "
                           + machineTooMuch.getPrice());

        System.out.println("Money inserted: "
                           + machineTooMuch.getBalance());

        machineTooMuch.printTicket();

        System.out.println("Balance after printing: "
                           + machineTooMuch.getBalance());

        System.out.println("Extra money is NOT refunded.");

        System.out.println("\n--- Exercise 2.2: Too Little Money ---");

        Task1 machineTooLittle = new Task1(500);

        machineTooLittle.insertMoney(300);

        System.out.println("Ticket price: "
                           + machineTooLittle.getPrice());

        System.out.println("Money inserted: "
                           + machineTooLittle.getBalance());

        machineTooLittle.printTicket();

        System.out.println("Balance after printing: "
                           + machineTooLittle.getBalance());

        System.out.println("The simple machine still prints the ticket.");
        System.out.println("The balance becomes negative.");

        System.out.println("\n--- Exercise 2.3 ---");

        Task1 machine3 = new Task1(700);

        System.out.println("New machine created.");
        System.out.println("Price: " + machine3.getPrice());
        System.out.println("Balance: " + machine3.getBalance());

        machine3.insertMoney(200);
        machine3.insertMoney(300);

        System.out.println("Balance after inserting 500 cents: "
                           + machine3.getBalance());

        machine3.insertMoney(200);

        System.out.println("Balance after inserting another 200 cents: "
                           + machine3.getBalance());

        machine3.printTicket();

        System.out.println("Balance after buying ticket: "
                           + machine3.getBalance());

        System.out.println("\n--- Exercise 2.4 ---");

        Task1 machine500 = new Task1(500);
        Task1 machine1000 = new Task1(1000);

        System.out.println("Machine 1:");
        machine500.insertMoney(500);
        machine500.printTicket();

        System.out.println("Machine 2:");
        machine1000.insertMoney(1000);
        machine1000.printTicket();

        System.out.println("The ticket format is the same.");
        System.out.println("Only the ticket price is different.");

        System.out.println("\n--- Exercise 2.5 ---");

        Task1 machine4 = new Task1(600);

        machine4.insertMoney(600);

        System.out.println("Using getBalance(): "
                           + machine4.getBalance());

        System.out.println("Using getAmount(): "
                           + machine4.getAmount());

        System.out.println("Both methods return the same balance.");
        System.out.println("The accessor name does not have to match the field name.");

        System.out.println("\n--- Exercise 2.7 ---");

        System.out.println("Correct class declaration:");
        System.out.println("public class Task1");

        System.out.println("\n--- Exercise 2.8 ---");

        System.out.println("A class can also be declared as:");
        System.out.println("class Task1");

        System.out.println("However, this program uses:");
        System.out.println("public class Task1");

        System.out.println("\n--- Exercise 2.9 ---");

        System.out.println("The keyword 'class' is required.");
        System.out.println("Correct form: public class Task1");

        System.out.println("\n--- Exercise 2.15 ---");

        System.out.println("TicketMachine contains these fields:");
        System.out.println("private int price;");
        System.out.println("private int balance;");
        System.out.println("private int total;");

        System.out.println("\n--- Exercise 2.26 ---");

        Task1 machine5 = new Task1(500);

        System.out.println("Initial total: "
                           + machine5.getTotal());

        machine5.insertMoney(500);
        machine5.printTicket();

        System.out.println("Total after one ticket: "
                           + machine5.getTotal());

        machine5.insertMoney(500);
        machine5.printTicket();

        System.out.println("Total after two tickets: "
                           + machine5.getTotal());

        System.out.println("\n--- Exercise 2.27 ---");

        System.out.println("getPrice() has an int return type.");
        System.out.println("Therefore it must contain a return statement.");
        System.out.println("Correct code:");
        System.out.println("return price;");

        System.out.println("\n--- Exercise 2.37 ---");

        machine.prompt();

        System.out.println("\n--- Exercise 2.38 ---");

        System.out.println("Using price:");
        System.out.println("# " + machine.getPrice() + " cents.");

        System.out.println("Using \"price\":");
        System.out.println("# " + "price" + " cents.");

        System.out.println("\n--- Exercise 2.41 ---");

        machine.showPrice();

        System.out.println("\n--- Exercise 2.42 ---");

        Task1 cheapMachine = new Task1(500);
        Task1 expensiveMachine = new Task1(1200);

        System.out.println("First machine:");
        cheapMachine.showPrice();

        System.out.println("Second machine:");
        expensiveMachine.showPrice();

        System.out.println("The output is different because each object");
        System.out.println("has its own price value.");

        System.out.println("\n========================================");
        System.out.println("          END OF TICKET LAB");
        System.out.println("========================================");
    }
}