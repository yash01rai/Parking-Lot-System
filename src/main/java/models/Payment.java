package models;

import java.sql.Date;
import java.sql.Time;

public class Payment extends BaseModel {

    private int amount;
    private PaymentMode Mode;
    private int refNumber;
    private Date date;
    private PaymentStatus paymentStatus;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMode getMode() {
        return Mode;
    }

    public void setMode(PaymentMode mode) {
        Mode = mode;
    }

    public int getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(int refNumber) {
        this.refNumber = refNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
