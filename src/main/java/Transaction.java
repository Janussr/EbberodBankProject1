import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    int transaction_id;
    int amount;
    LocalDate dateOfTransaction;

    public Transaction(int transaction_id, int amount, LocalDate dateOfTransaction) {
        this.transaction_id = transaction_id;
        this.amount = amount;
        this.dateOfTransaction = LocalDate.now();
    }
}
