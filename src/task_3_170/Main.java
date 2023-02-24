package task_3_170;

import java.util.List;
import java.util.function.Predicate;

public class Main {

  static class Account {

    public Account(String number, Long balance, boolean isLocked) {
      this.number = number;
      this.balance = balance;
      this.isLocked = isLocked;
    }

    public String getNumber() {
      return number;
    }

    public void setNumber(String number) {
      this.number = number;
    }

    public Long getBalance() {
      return balance;
    }

    public void setBalance(Long balance) {
      this.balance = balance;
    }

    public boolean isLocked() {
      return isLocked;
    }

    public void setLocked(boolean locked) {
      isLocked = locked;
    }

    String number;
    Long balance;
    boolean isLocked;
  }

  public static void main(String[] args) {
    List<Account> accounts = List.of(
        new Account("001", 1000L, false),
        new Account("002", 10000L, false),
        new Account("003", 2000L, false),
        new Account("004", 5000L, true),
        new Account("005", 100000000L, false)
    );
    List<Account> nonEmptyAccounts = filter(accounts, (account) -> account.getBalance() > 0);

    List<Account> accountsWithTooMuchMoney = filter(accounts,
        (account) -> !account.isLocked && account.getBalance() >= 100000000L);
  }

  private static List<Account> filter(List<Account> accounts, Predicate<Account> predicate) {
    return accounts.stream().filter(predicate).toList();
  }
}