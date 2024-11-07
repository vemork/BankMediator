public class BankMediator implements IBankMediator {

  private final LoanApprovalManager loanApprovalManager;
  private final RiskValidation riskValidation;

  public BankMediator(LoanApprovalManager loanApprovalManager, RiskValidation riskValidation) {
    this.loanApprovalManager = loanApprovalManager;
    this.riskValidation = riskValidation;
  }

  public void processLoanRequest(Client client, double loanAmount) {
    double approvedAmount = riskValidation.validateRisk(client, loanAmount);

    if (approvedAmount > 0) {
      loanApprovalManager.addApprovedClient(client);
      loanApprovalManager.updateBalance(client, approvedAmount);
    } else {
      loanApprovalManager.addRejectedClient(client);
    }
  }

  public void showResults() {
    loanApprovalManager.showApprovedClients();
    loanApprovalManager.showRejectedClients();
  }
}
