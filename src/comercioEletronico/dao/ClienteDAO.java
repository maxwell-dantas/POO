package comercioEletronico.dao;
import comercioEletronico.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileWriter;
import java.io.FileReader;

public class ClienteDAO {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private static final Gson gson = new Gson();

    public void inserir(Cliente cliente) {
        this.clientes.add(cliente);
        this.salvar();
    }

    public Cliente listarId(int id) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getId() == id) {return cliente;}
        }
        return null;
    }

    public void atualizar(Cliente cliente, String nomeNovo, String emailNovo, String telefoneNovo) {
        cliente.setNome(nomeNovo);
        cliente.setEmail(emailNovo);
        cliente.setTelefone(telefoneNovo);
        this.salvar();
    }

    public void excluir(Cliente cliente) {
        this.clientes.remove(cliente);
        this.salvar();
    }

    public ArrayList<Cliente> listar() {return this.clientes;}

    // Busca meu arquivo e insere ele na memória do programa
    public void abrir() {
        try {
            // 1. Abre o leitor para o caminho onde o arquivo foi salvo
            FileReader leitor = new FileReader("src/comercioEletronico/data/clientes.json");

            // 2. Pega o tipo da lista para evitar a amnésia do Java runtime
            Type listaTipo = new TypeToken<ArrayList<Cliente>>(){}.getType();

            // 3. O Gson lê o arquivo e já preenche a lista de uma vez
            this.clientes = gson.fromJson(leitor, listaTipo);

            if (this.clientes == null) {
                this.clientes = new ArrayList<>();
            }

            // 4. fecha o leitor
            leitor.close();

        } catch (IOException e) {
            // Caso o arquivo não exista ainda, cria uma lista vazia para evitar erros (o método gson.fromJson)
            this.clientes = new ArrayList<>();
        }
    }

    public void salvar() {
        try {
            // 1. Abertura de arquivo
            FileWriter escritor = new FileWriter("src/comercioEletronico/data/clientes.json");

            // 2. Converte a lista de objetos em texto Json
            String textoJson = gson.toJson(this.clientes);

            // 3. Escreve o texto no arquivo
            escritor.write(textoJson);

            // 4. Fecha o arquivo para confirmar a gravação
            escritor.close();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
