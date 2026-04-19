package Lista05.boleto;

public enum Pagamento {
    EM_ABERTO(1), PAGO_PARCIAL(2), PAGO(3);

    private final int codigoInterno;

    Pagamento(int codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public int getCodigoInterno() {
        return codigoInterno;
    }
}
