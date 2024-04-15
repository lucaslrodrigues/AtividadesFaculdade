public class ContaBancaria {
    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
