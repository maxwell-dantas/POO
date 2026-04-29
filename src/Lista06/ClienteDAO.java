package Lista06;
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
    }

    public Cliente listarId(int id) {
        this.abrir();
        for (Cliente objeto : this.clientes) {
            if (objeto.getId() == id) {return objeto;}
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
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cliente.getId() == this.clientes.get(i).getId()) {
                this.clientes.remove(i);
                System.out.println("Cliente removido com sucesso!");
                this.salvar();
                break;
            }
        }
    }

    public ArrayList<Cliente> listar() {return this.clientes;}

    public void abrir() {
        try {
            // 1. Abre o leitor para o caminho onde o arquivo foi salvo
            FileReader leitor = new FileReader("src/Lista06/clientes.json");

            // 2. Pega o tipo da lista para evitar a amnésia do Java runtime
            Type listaTipo = new TypeToken<ArrayList<Cliente>>(){}.getType();

            // 3. O Gson lê o arquivo e já preenche a lista de uma vez
            this.clientes = gson.fromJson(leitor, listaTipo);

            // 4. fecha o leitor
            leitor.close();

            System.out.println("Dados carregados com sucesso!");

        } catch (IOException e) {
            // Caso o arquivo não exista ainda, criamos uma lista vazia para evitar erros
            this.clientes = new ArrayList<>();
            System.out.println("Arquivo não encontrado. Iniciando lista vazia...");
        }
    }

    public void salvar() {
        try {
            // 1. Abertura de arquivo
            FileWriter escritor = new FileWriter("src/Lista06/clientes.json");

            // 2. Converte a lista de objetos em texto Json
            String textoJson = gson.toJson(this.clientes);

            // 3. Escreve o texto no arquivo
            escritor.write(textoJson);

            // 4. Fecha o arquivo para confirmar a gravação
            escritor.close();

            System.out.println("Dados salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
