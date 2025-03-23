package br.com.project.springjpa2.models.enums;

public enum PaymentStatus {

    WAITING(1, "Pendente"),
    PAIDOFF(2, "Quitado"),
    CANCELED(3, "Cancelado");

    private int code;
    private String description;

    private PaymentStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
    public static PaymentStatus toEnum(Integer code) {
        if(code == null) {
            return null;
        }
        for(PaymentStatus value : PaymentStatus.values()) {
            if(code.equals(value.getCode())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + code);
    }
}
