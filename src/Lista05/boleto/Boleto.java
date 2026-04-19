package Lista05.boleto;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Boleto {
    private String codBarras;
    private LocalDateTime dataEmissao;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private double valorBoleto;
    private double valorPago;
    private double troco;
    private Pagamento situacaoPagamento;

    public Boleto(String codBarras, LocalDateTime dataEmissao, LocalDate dataVencimento, double valorBoleto) {
        this.codBarras = codBarras;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.valorBoleto = valorBoleto;
        this.situacaoPagamento = Pagamento.EM_ABERTO;
    }

    public void Pagar(double valorPago) {
        if (valorPago > 0 && this.situacaoPagamento != Pagamento.PAGO) {
            this.valorPago += valorPago;
            this.dataPagamento = LocalDateTime.now();
            if (this.valorPago >= valorBoleto) {
                this.situacaoPagamento = Pagamento.PAGO;
            } else this.situacaoPagamento = Pagamento.PAGO_PARCIAL;
            if (this.valorPago > valorBoleto) {
                setTroco(this.valorPago - valorBoleto);
            }
        } else throw new IllegalArgumentException("O valor inserido é inválido ou o boleto já foi pago!");
    }

    private void setTroco(double troco) {
        this.troco = troco;
    }

    public double getTroco() {return troco;}

    public Pagamento Situacao() {
        return this.situacaoPagamento;
    }

    @Override
    public String toString() {
        return "Código de Barras: " + codBarras + "\nData de Emissão: " + dataEmissao
                + "\nData de Vencimento: " + dataVencimento + "\nValor Pago: " + valorPago + "\nTroco: " + troco
                + "\nSituação do Pagamento: " + situacaoPagamento + "\nData do Pagamento: " + dataPagamento;
    }
}
