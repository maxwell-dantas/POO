package comercioEletronico.model;

public class VendaItem {
    private int id;
    private int quantidade;
    private double preco;
    private String item;
    private int idVenda;
    private Produto produto;

    public VendaItem(int quantidade, Produto produto) {
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        this.setPreco();
        this.setItem();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.setItem();
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0 || quantidade > produto.getEstoque()) {throw new IllegalArgumentException("Insira uma quantidade válida!");}
        this.quantidade = quantidade;
        this.produto.setEstoque(this.produto.getEstoque() - quantidade);
        this.setPreco();
    }

    private void setPreco() {
        this.preco = this.quantidade * this.produto.getPreco();
    }

    private void setItem() {
        this.item = this.produto.getDescricao();
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getItem() {
        return this.item;
    }

    public int getIdVenda() {
        return this.idVenda;
    }

    public int getIdProduto() {
        return this.produto.getId();
    }

    public Produto getProduto() {
        return this.produto;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.item + " - " + this.quantidade + " unidades - " + String.format("%.2f", this.preco)
                + " - ID Produto: " + this.getIdProduto() + " - ID Venda: " + this.idVenda;
    }
}
