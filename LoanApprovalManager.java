import java.util.ArrayList;
import java.util.List;

public class LoanApprovalManager {

  private final List<Client> approvedClients;
  private final List<Client> rejectedClients;

  public LoanApprovalManager() {
    approvedClients = new ArrayList<>();
    rejectedClients = new ArrayList<>();
  }

  public void addApprovedClient(Client client) {
    approvedClients.add(client);
  }

  public void addRejectedClient(Client client) {
    rejectedClients.add(client);
  }

  public void showApprovedClients() {
    System.out.println("\nApproved Clients:");
    for (Client client : approvedClients) {
      System.out.println(client.getName() + " - Balance: " + client.getBalance());
    }
  }

  public void showRejectedClients() {
    System.out.println("\nRejected Clients:");
    for (Client client : rejectedClients) {
      System.out.println(client.getName() + " - Loan Rejected");
    }
  }

  public void updateBalance(Client client, double amount) {
    client.updateBalance(amount);
  }
}
