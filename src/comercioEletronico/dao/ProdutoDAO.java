package comercioEletronico.dao;
import comercioEletronico.model.Categoria;
import comercioEletronico.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileWriter;
import java.io.FileReader;

public class ProdutoDAO {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private static final Gson gson = new Gson();

    public void inserir(Produto produto) {
        this.produtos.add(produto);
        this.salvar();
    }

    public Produto listarId(int id) {
        for (Produto produto : this.produtos) {
            if (produto.getId() == id) {return produto;}
        }
        return null;
    }

    public void atualizar(Produto produto, String descricaoNova, double precoNovo, int estoqueNovo, Categoria categoriaNova) {
        produto.setDescricao(descricaoNova);
        produto.setPreco(precoNovo);
        produto.setEstoque(estoqueNovo);
        produto.setCategoria(categoriaNova);
        this.salvar();
    }

    public void excluir(Produto produto) {
        this.produtos.remove(produto);
        this.salvar();
    }

    public ArrayList<Produto> listar() {return this.produtos;}

    // Busca meu arquivo e insere ele na memória do programa
    public void abrir() {
        try {
            // 1. Abre o leitor para o caminho onde o arquivo foi salvo
            FileReader leitor = new FileReader("src/comercioEletronico/data/produtos.json");

            // 2. Pega o tipo da lista para evitar a amnésia do Java runtime
            Type listaTipo = new TypeToken<ArrayList<Produto>>(){}.getType();

            // 3. O Gson lê o arquivo e já preenche a lista de uma vez
            this.produtos = gson.fromJson(leitor, listaTipo);

            if (this.produtos == null) {
                this.produtos = new ArrayList<>();
            }

            // 4. fecha o leitor
            leitor.close();

        } catch (IOException e) {
            // Caso o arquivo não exista ainda, cria uma lista vazia para evitar erros (o método gson.fromJson)
            this.produtos = new ArrayList<>();
        }
    }

    public void salvar() {
        try {
            // 1. Abertura de arquivo
            FileWriter escritor = new FileWriter("src/comercioEletronico/data/produtos.json");

            // 2. Converte a lista de objetos em texto Json
            String textoJson = gson.toJson(this.produtos);

            // 3. Escreve o texto no arquivo
            escritor.write(textoJson);

            // 4. Fecha o arquivo para confirmar a gravação
            escritor.close();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
