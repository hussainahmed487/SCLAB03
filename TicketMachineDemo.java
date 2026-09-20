public class TicketMachineDemo {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      TICKET MACHINE CONSOLE DEMO       ");
        System.out.println("========================================\n");

        // 1. Create a ticket machine with a price of 500 cents ($5.00)
        TicketMachine myMachine = new TicketMachine(500);
        System.out.println("-> Created a ticket machine.");
        System.out.println("   Ticket Price: " + myMachine.getPrice() + " cents.");
        System.out.println("   Initial Balance: " + myMachine.getBalance() + " cents.");
        System.out.println("   Initial Total Collected: " + myMachine.getTotal() + " cents.\n");

        // 2. Insert money in installments
        System.out.println("-> Inserting money...");
        myMachine.insertMoney(200);
        System.out.println("   Inserted 200 cents. Current Balance: " + myMachine.getBalance() + " cents.");

        myMachine.insertMoney(300);
        System.out.println("   Inserted another 300 cents. Current Balance: " + myMachine.getBalance() + " cents.\n");

        // 3. Print a ticket
        System.out.println("-> Attempting to print ticket:");
        myMachine.printTicket();
        System.out.println();

        // 4. Check state after printing
        System.out.println("-> State after successful print:");
        System.out.println("   Current Balance: " + myMachine.getBalance() + " cents.");
        System.out.println("   Total Collected: " + myMachine.getTotal() + " cents.\n");

        // 5. Test emptying the machine
        System.out.println("-> Emptying the machine cash box...");
        double collectedCash = myMachine.emptyMachine();
        System.out.println("   Successfully collected: " + TicketMachine.formatMoney(collectedCash) + "\n");
        System.out.println("   Total in machine after emptying: " + TicketMachine.formatMoney(myMachine.getTotal()) + "\n");

        System.out.println("========================================");
        System.out.println("         DEMO EXECUTION FINISHED        ");
        System.out.println("========================================");
    }
}