package br.com.project.springjpa2.models;

import java.time.Instant;

import br.com.project.springjpa2.models.enums.PaymentStatus;
import jakarta.persistence.Entity;

@Entity
public class TicketPayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Instant expirationDate;
    private Instant paymentDate;

    public TicketPayment(){}

    public TicketPayment(Long id, PaymentStatus paymentStatus, Order order, Instant expirationDate, Instant paymentDate) {
        super(id, paymentStatus, order);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }
    
}
