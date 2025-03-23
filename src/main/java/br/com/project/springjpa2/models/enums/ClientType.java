package br.com.project.springjpa2.models.enums;

public enum ClientType {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int code;
    private String description;

    private ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(ClientType value : ClientType.values()) {
            if(cod.equals(value.getCode())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
