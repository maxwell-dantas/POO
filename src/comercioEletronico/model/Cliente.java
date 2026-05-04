package comercioEletronico.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public int getId() {return this.id;}
    public String getNome() {return this.nome;}
    public String getEmail() {return this.email;}
    public String getTelefone() {return this.telefone;}

    @Override
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.email + " - " + this.telefone;
    }
}
