package br.com.project.springjpa2.models;

import br.com.project.springjpa2.models.enums.PaymentStatus;
import jakarta.persistence.Entity;

@Entity
public class CardPayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Integer installments;

    public CardPayment(){}

    public CardPayment(Long id, PaymentStatus paymentStatus, Order order, Integer installments) {
        super(id, paymentStatus, order);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

}
