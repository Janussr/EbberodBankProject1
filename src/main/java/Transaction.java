
import java.util.Date;

public class Transaction {
    private int transaction_id;
    private int amount;
    private Date date;

    //OBS! transaction_ID er ikke added til constructor! men det skal den senere hen, den er bare fjernet for testing purposes.
    public Transaction(int amount, Date date) {
        this.transaction_id = transaction_id;
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public Date date() {
        return date;
    }

}
