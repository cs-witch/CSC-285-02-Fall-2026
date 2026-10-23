package jones.project1;

public class BankAccount {
  private int balance = 1000;
  // Volatile allows threads to see changes to this flag.
  private volatile boolean acceptingTransactions = true;

  public synchronized void deposit(int amount) {
    int oldBalance = balance;
    Thread.yield();

    balance = oldBalance + amount;
  }

  public synchronized void withdraw(int amount) {
    int oldBalance = balance;
    Thread.yield();

    if (oldBalance >= amount) {
      balance = oldBalance - amount;
    }
  }

  public synchronized int getBalance() {
    return balance;
  }

  public boolean isAcceptingTransactions() {
    return acceptingTransactions;
  }

  public void closeAccount() {
    acceptingTransactions = false;
  }
}
