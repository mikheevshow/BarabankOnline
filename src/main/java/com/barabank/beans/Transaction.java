package com.barabank.beans;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "transaction_id_generator")
    //@SequenceGenerator(name = "transaction_id_generator", sequenceName = "transaction_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "from_account", nullable = false, updatable = false)
    private long fromAccount;

    @Column(name = "to_account", nullable = false, updatable = false)
    private long toAccount;

    @Column(name = "sum", nullable = false, updatable = false)
    private BigDecimal sum;

    @Column(name = "date", nullable = false, updatable = false)
    private OffsetDateTime date;

    public Transaction() {
        this.setDate(OffsetDateTime.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }
}
