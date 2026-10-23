package jones.project1;

public class BankSimulation {
  public static void main(String[] args) throws InterruptedException {
    BankAccount account = new BankAccount();
    Runnable depositor =
        () -> {
          int transactions = 0;
          while (account.isAcceptingTransactions()) {
            account.deposit(10);
            transactions++;
            if (transactions % 100 == 0) {
              Thread.yield();
            }
          }
          System.out.println(Thread.currentThread().getName() + " finished depositing.");
        };
    Runnable withdrawer =
        () -> {
          int transactions = 0;
          while (account.isAcceptingTransactions()) {
            account.withdraw(10);
            transactions++;
            if (transactions % 100 == 0) {
              Thread.yield();
            }
          }
          System.out.println(Thread.currentThread().getName() + " finished withdrawing.");
        };
    Thread d1 = new Thread(depositor, "Depositor-1");
    Thread d2 = new Thread(depositor, "Depositor-2");
    Thread w1 = new Thread(withdrawer, "Withdrawer-1");
    Thread w2 = new Thread(withdrawer, "Withdrawer-2");
    d1.start();
    d2.start();
    w1.start();
    w2.start();
    // The manager allows transactions for a short time.
    Thread.sleep(1000);
    account.closeAccount();
    System.out.println("Manager: Account is closed.");
    // Wait for all customer threads to finish.
    d1.join();
    d2.join();
    w1.join();
    w2.join();
    System.out.println("Final balance: $" + account.getBalance());
    System.out.println("All transactions have stopped.");
  }
}
