public class Client {
  private final String name;
  private final RiskProfile riskProfile;
  private double accountBalance;

  public Client(String name, RiskProfile riskProfile, double initialBalance) {
    this.name = name;
    this.riskProfile = riskProfile;
    this.accountBalance = initialBalance;
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return accountBalance;
  }

  public RiskProfile getRiskProfile() {
    return riskProfile;
  }

  public void updateBalance(double amount) {
    accountBalance += amount;
    System.out.println(name + "'s new account balance is: " + accountBalance);
  }
}
