package comercioEletronico.dao;
import comercioEletronico.model.Venda;
import comercioEletronico.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileWriter;
import java.io.FileReader;

public class VendaDAO {
    private ArrayList<Venda> vendas = new ArrayList<>();
    private static final Gson gson = new Gson();

    public void inserir(Venda venda) {
        this.vendas.add(venda);
        this.salvar();
    }

    public Venda listarId(int id) {
        for (Venda venda : this.vendas) {
            if (venda.getId() == id) {return venda;}
        }
        return null;
    }

    public void atualizar(Venda venda, Cliente cliente) {
        venda.setCliente(cliente);
        this.salvar();
    }

    public void excluir(Venda venda) {
        this.vendas.remove(venda);
        this.salvar();
    }

    public ArrayList<Venda> listar() {return this.vendas;}

    // Busca meu arquivo e insere ele na memória do programa
    public void abrir() {
        try {
            // 1. Abre o leitor para o caminho onde o arquivo foi salvo
            FileReader leitor = new FileReader("src/comercioEletronico/data/vendas.json");

            // 2. Pega o tipo da lista para evitar a amnésia do Java runtime
            Type listaTipo = new TypeToken<ArrayList<Venda>>(){}.getType();

            // 3. O Gson lê o arquivo e já preenche a lista de uma vez
            this.vendas = gson.fromJson(leitor, listaTipo);

            if (this.vendas == null) {
                this.vendas = new ArrayList<>();
            }

            // 4. fecha o leitor
            leitor.close();

        } catch (IOException e) {
            // Caso o arquivo não exista ainda, cria uma lista vazia para evitar erros (o método gson.fromJson)
            this.vendas = new ArrayList<>();
        }
    }

    public void salvar() {
        try {
            // 1. Abertura de arquivo
            FileWriter escritor = new FileWriter("src/comercioEletronico/data/vendas.json");

            // 2. Converte a lista de objetos em texto Json
            String textoJson = gson.toJson(this.vendas);

            // 3. Escreve o texto no arquivo
            escritor.write(textoJson);

            // 4. Fecha o arquivo para confirmar a gravação
            escritor.close();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
