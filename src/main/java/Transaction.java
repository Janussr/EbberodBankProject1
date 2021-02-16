import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private int transaction_id;
    private int amount;
    private LocalDate dateOfTransaction;

    public Transaction(int transaction_id, int amount, LocalDate dateOfTransaction) {
        this.transaction_id = transaction_id;
        this.amount = amount;
        this.dateOfTransaction = LocalDate.now();
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

}
