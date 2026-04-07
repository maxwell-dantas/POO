/* Escrever as classes Empresa e Cliente, usadas para cadastrar os clientes de uma empresa de cartões de crédito.
Cada empresa deve ter um nome e uma lista de clientes;
• O construtor da classe Empresa recebe o nome da empresa e possui métodos recuperar e alterar esse valor
(get/set);
• A classe define as seguintes operações: Inserir, para cadastrar um cliente e Listar, para retornar uma lista com
os clientes já cadastrados;
• A classe Cliente modela um cliente que deve possuir nome, cpf e limite de crédito;
• Um cliente pode também ter um sócio, também cliente. Nesta situação, o seu limite de crédito deve ser somado
ao limite de crédito de seu sócio e vice-versa;
• A sociedade deve acontecer em pares, ou seja, quando um cliente A for sócio de um cliente B, B deve ser sócio
de A;
• O construtor da classe recebe os dados iniciais do cliente;
• O método SetSocio é usado para definir a sociedade entre dois clientes;
• O método GetLimite retorna o limite do cliente, considerando o limite de seu sócio quando existir;
• O método ToString retorna um texto com os dados do cliente;
• Insira outros atributos e métodos nas classes, caso necessário. */

package Lista04;
import java.util.ArrayList;

class Empresa {
    private String nome;
    private ArrayList<Cliente> clientes;

    public Empresa(String nome) {
        this.setNome(nome);
        clientes = new ArrayList<>();
    }

    public void setNome(String nome) {this.nome = nome;}
    public String getNome() {return nome;}

    public void inserir(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> listar() {
        return clientes;
    }

    @Override
    public String toString() {
        return "Quantidade de clientes: " + clientes.size();
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private double limite;
    private Cliente socio;

    public Cliente(String nome, String cpf, double limite) {
        this.setNome(nome);
        this.setCPF(cpf);
        this.setLimite(limite);
    }

    public void setNome(String nome) {this.nome = nome;}
    public void setCPF(String cpf) {this.cpf = cpf;}

    public void setLimite(double limite) {
        if (limite >= 0) {
            this.limite = limite;
        } else throw new IllegalArgumentException("Insira um limite válido!");}

    public String getNome() {return nome;}
    public String getCPF() {return cpf;}
    public double getLimite() {
        if (this.socio == null) {
            return limite;
        } else return limite + socio.limite;
    }


    public void setSocio(Cliente clienteSocio) {
        if (this.socio != null) {
            this.socio.socio = null;
        }

        if (clienteSocio.socio != null) {
            clienteSocio.socio.socio = null;
        }

        this.socio = clienteSocio;
        clienteSocio.socio = this;
    }

    @Override
    public String toString() {
        String nomeSocio = (this.socio != null) ? this.socio.nome : "sem assosiação";
        return "Cliente: " + nome + "\nCPF: " + cpf + "\nLimite: " + getLimite() + "\nSócio: " + nomeSocio;
    }

}

public class Q2 {
    public static void main(String[] args) {

        System.out.println("--- 1. TESTE DA EMPRESA E CADASTRO DE CLIENTES ---");
        Empresa empresa = new Empresa("IFRN Credit");
        System.out.println("Nome da Empresa: " + empresa.getNome());

        // Criando clientes
        Cliente c1 = new Cliente("Maxwell", "111.111.111-11", 1000.0);
        Cliente c2 = new Cliente("Joao", "222.222.222-22", 2000.0);
        Cliente c3 = new Cliente("Maria", "333.333.333-33", 1500.0);

        // Inserindo na empresa
        empresa.inserir(c1);
        empresa.inserir(c2);
        empresa.inserir(c3);

        // Testando o toString da Empresa e o listar
        System.out.println(empresa);
        System.out.println("Lista de clientes cadastrados: " + empresa.listar().size() + " clientes.");

        System.out.println("\n--- 2. TESTE DE LIMITES INDIVIDUAIS (SEM SÓCIO) ---");
        System.out.println("Limite do " + c1.getNome() + ": " + c1.getLimite()); // Esperado: 1000
        System.out.println("Limite do " + c2.getNome() + ": " + c2.getLimite()); // Esperado: 2000

        System.out.println("\n--- 3. TESTE DE SOCIEDADE (SOMA DE LIMITES) ---");
        c1.setSocio(c2); // Maxwell se torna sócio de Joao
        System.out.println("Sociedade firmada: " + c1.getNome() + " e " + c2.getNome());

        System.out.println("Novo limite do " + c1.getNome() + ": " + c1.getLimite()); // Esperado: 3000 (1000 + 2000)
        System.out.println("Novo limite do " + c2.getNome() + ": " + c2.getLimite()); // Esperado: 3000 (2000 + 1000)

        System.out.println("\nImpressão dos dados do " + c1.getNome() + " com o toString:");
        System.out.println(c1);

        System.out.println("\n--- 4. TESTE DE TROCA DE SOCIEDADE (DEVE DESFAZER A ANTERIOR) ---");
        c1.setSocio(c3); // Maxwell desfaz com Joao e se torna sócio de Maria
        System.out.println(c1.getNome() + " trocou de sociedade para " + c3.getNome());

        System.out.println("Limite do " + c1.getNome() + " atualizado: " + c1.getLimite()); // Esperado: 2500 (1000 + 1500)
        System.out.println("Limite da " + c3.getNome() + " atualizado: " + c3.getLimite()); // Esperado: 2500 (1500 + 1000)

        // O limite de João deve voltar a ser apenas o dele, já que perdeu o sócio
        System.out.println("Limite do " + c2.getNome() + " (voltou ao individual): " + c2.getLimite()); // Esperado: 2000
    }
}