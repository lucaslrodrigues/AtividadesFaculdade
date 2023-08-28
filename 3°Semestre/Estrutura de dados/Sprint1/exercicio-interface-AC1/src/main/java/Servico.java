public class Servico implements Vendavel{
    private String descricao;
    private int codigo;
    private int quantHoras;
    private double valorHora;

    public Servico(String descricao, int codigo, int quantHoras, double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantHoras = quantHoras;
        this.valorHora = valorHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(int quantHoras) {
        this.quantHoras = quantHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double getValorVenda() {
        return quantHoras * valorHora;
    }

    @Override
    public String toString() {
        return """
                Serviço
                Descrição: %s
                Código: %d
                Quantidade de horas: %d
                Valor hora: %.2f
                Valor de venda: %.2f
                """.formatted(descricao, codigo, quantHoras, valorHora, getValorVenda());
    }
}
