package comercioEletronico.model;
import java.time.LocalDateTime;

public class Produto {
    private int id;
    private String descricao;
    private double preco;
    private int estoque;
    private Categoria categoria;

    public Produto(String descricao, double preco, int estoque, Categoria categoria) {
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setEstoque(estoque);
        this.setCategoria(categoria);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Insira um preço válido!");
        }
        this.preco = preco;
    }
    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Insira um valor de estoque válido!");
        }
        this.estoque = estoque;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public int getCategoriaId() {
        return categoria.getId();
    }

    @Override
    public String toString() {
        return this.id + " - " + this.descricao + " - R$ " + this.preco + " - " + this.estoque + " unidades"
                + " - ID categoria: " + categoria;
    }
}
