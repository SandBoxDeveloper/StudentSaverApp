package com.charlesmolyneux.studentsaver;

import java.util.Date;

/**
 * Created by charlesmolyneux on 30/06/2016.
 */
public class PaymentClass {
    private String paymentType;
    private String paymentCategory;
    private String paymentAmount;
    private String paymentReoccurment;
    private String paymentDate;

    public PaymentClass(String paymentType, String paymentCategory, String paymentAmound, String paymentReoccurment, String paymentDate) {
        this.paymentType = paymentType;
        this.paymentCategory = paymentCategory;
        this.paymentAmount = paymentAmound;
        this.paymentReoccurment = paymentReoccurment;
        this.paymentDate = paymentDate;
    }


    //Payment Name (Identifies payment)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    //Expense or Income?
    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmound) {
        this.paymentAmount = paymentAmound;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentReoccurment() {
        return paymentReoccurment;
    }

    public void setPaymentReoccurment(String paymentReoccurment) {
        this.paymentReoccurment = paymentReoccurment;
    }
}
