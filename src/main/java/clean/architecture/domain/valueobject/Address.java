package clean.architecture.domain.valueobject;

public record Address(String cep, Integer number, String complement) {
    public Address {
        if (cep == null || !cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("Invalid CEP");
        }
    }
}
