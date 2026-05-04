package comercioEletronico.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private int id;
    private String data;
    private boolean carrinho = false;
    private double total;
    private Cliente cliente;

    public Venda(Cliente cliente) {
        this.setCliente(cliente);
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setData() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.data = LocalDateTime.now().format(formato);
    }

    public void setCarrinho(boolean carrinho) {
        this.carrinho = carrinho;
        this.setData();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public double getTotal() {
        return this.total;
    }

    public int getIdCliente() {
        return this.cliente.getId();
    }

    public Cliente getCliente() {return this.cliente;}

    @Override
    public String toString() {
        return this.id + " - " + String.format("R$ %.2f", this.total) + " - Data da compra: " + this.data
                + " - Cliente: " + this.getCliente();
    }
}
