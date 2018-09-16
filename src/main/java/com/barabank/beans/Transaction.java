package com.barabank.beans;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "transaction",schema = "public")
public class Transaction implements Serializable {

    @Id
    @SequenceGenerator(name = "transaction_id_seq",sequenceName = "transaction_id_seq",allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transaction_id_seq")
    @Column(name = "transaction_id", nullable = false, unique = true, updatable = false)
    private long transactionId;

    @Column(name = "from_account", nullable = false, updatable = false)
    private long fromAccount;

    @Column(name = "to_account", nullable = false, updatable = false)
    private long toAccount;

    @Column(name = "sum", nullable = false, updatable = false)
    private BigDecimal sum;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    public Transaction() {
        this.setDate(LocalDateTime.now());
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long id) {
        this.transactionId = id;
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + transactionId +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }
}
