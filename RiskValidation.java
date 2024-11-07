public class RiskValidation {

  private final double taxesThresholdLow;
  private final double taxesThresholdMedium;

  public RiskValidation(double taxesThresholdLow, double taxesThresholdMedium) {
    this.taxesThresholdLow = taxesThresholdLow;
    this.taxesThresholdMedium = taxesThresholdMedium;
  }

  public double validateRisk(Client client, double loanAmount) {
    double approvedAmount = 0;
    RiskProfile profile = client.getRiskProfile();

    switch (profile) {
      case HIGH:
        System.out.println(client.getName() + " has a high risk profile. Loan is denied.");
        break;
      case MEDIUM:
        approvedAmount = loanAmount * 0.5;
        System.out.println(client.getName() + " has a medium risk profile. Loan approved for " + approvedAmount + ".");
        break;
      case LOW:
        approvedAmount = loanAmount;
        System.out.println(client.getName() + " has a low risk profile. Loan approved for " + approvedAmount + ".");
        break;
    }

    if (approvedAmount > 0) {
      double tax = switch (profile) {
        case LOW -> approvedAmount * taxesThresholdLow;
        case MEDIUM -> approvedAmount * taxesThresholdMedium;
        default -> 0;
      };
      approvedAmount -= tax;
      System.out.println("Tax applied: " + tax + ". Final approved amount: " + approvedAmount);
    }

    return approvedAmount;
  }
}
