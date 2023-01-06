package models;

import java.util.Date;

public class Invoice extends BaseModel  {
    private Ticket ticket;
    private Date exitTime;
    private ExitGate exitGate;
    private Double amount;
    private Operator generatedByOperator;
    private InvoicePaidStatus invoicePaidStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public ExitGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Operator getGeneratedByOperator() {
        return generatedByOperator;
    }

    public void setGeneratedByOperator(Operator generatedByOperator) {
        this.generatedByOperator = generatedByOperator;
    }

    public InvoicePaidStatus getInvoicePaidStatus() {
        return invoicePaidStatus;
    }

    public void setInvoicePaidStatus(InvoicePaidStatus invoicePaidStatus) {
        this.invoicePaidStatus = invoicePaidStatus;
    }
}
