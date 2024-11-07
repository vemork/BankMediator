public class Main {
  public static void main(String[] args) {
    Client client1 = new Client("John Doe", RiskProfile.HIGH, 1000);
    Client client2 = new Client("Jane Smith", RiskProfile.MEDIUM, 2000);
    Client client3 = new Client("Alice Johnson", RiskProfile.LOW, 3000);

    double taxesThresholdLow = 0.01;
    double taxesThresholdMedium = 0.025;

    LoanApprovalManager loanApprovalManager = new LoanApprovalManager();
    RiskValidation riskValidation = new RiskValidation(taxesThresholdLow, taxesThresholdMedium );

    BankMediator bankMediator = new BankMediator(loanApprovalManager, riskValidation);

    System.out.println("\nLoan request for client 1:");
    bankMediator.processLoanRequest(client1, 5000);

    System.out.println("\nLoan request for client 2:");
    bankMediator.processLoanRequest(client2, 5000);

    System.out.println("\nLoan request for client 3:");
    bankMediator.processLoanRequest(client3, 5000);

    bankMediator.showResults();
  }
}
