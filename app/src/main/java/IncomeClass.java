import java.util.Date;

/**
 * Created by charlesmolyneux on 30/06/2016.
 */
public class IncomeClass {
    private String incomeName;
    private Float incomeAmount;
    private Date incomeDue;

    public void IncomeClass(String inName, Float inAmount, Date inDueDate) {
        this.setIncomeName(inName);
        this.setIncomeAmount(inAmount);
        this.setIncomeDue(inDueDate);
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public Float getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Float incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Date getIncomeDue() {
        return incomeDue;
    }

    public void setIncomeDue(Date incomeDue) {
        this.incomeDue = incomeDue;
    }
}
