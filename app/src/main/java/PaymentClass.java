import java.util.Date;

/**
 * Created by charlesmolyneux on 30/06/2016.
 */
public class PaymentClass {
    private String paymentType;
    private String paymentCategory;
    private Float paymentAmound;
    private String paymentReoccurment;
    private Date paymentDate;

    public PaymentClass(String paymentType, String paymentCategory, Float paymentAmound, String paymentReoccurment, Date paymentDate) {
        this.paymentType = paymentType;
        this.paymentCategory = paymentCategory;
        this.paymentAmound = paymentAmound;
        this.paymentReoccurment = paymentReoccurment;
        this.paymentDate = paymentDate;
    }


    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public Float getPaymentAmound() {
        return paymentAmound;
    }

    public void setPaymentAmound(Float paymentAmound) {
        this.paymentAmound = paymentAmound;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentReoccurment() {
        return paymentReoccurment;
    }

    public void setPaymentReoccurment(String paymentReoccurment) {
        this.paymentReoccurment = paymentReoccurment;
    }
}
