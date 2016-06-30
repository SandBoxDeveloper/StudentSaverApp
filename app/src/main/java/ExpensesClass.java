import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by charlesmolyneux on 30/06/2016.
 */
public class ExpensesClass {

    private String expenseName;
    private Float expenseValue;
    private Date expenseDue;

    public ExpensesClass(String inExpName, Float inExpValue, Date inExpDate){
        this.setExpenseName(inExpName);
        this.setExpenseValue(inExpValue);
        this.setExpenseDue(inExpDate);
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Float getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(Float expenseValue) {
        this.expenseValue = expenseValue;
    }

    public Date getExpenseDue() {
        return expenseDue;
    }

    public void setExpenseDue(Date expenseDue) {
        this.expenseDue = expenseDue;
    }
}
