package Lista01;

/* A classe deve ter atributos para armazenar o nome do titular da conta, o número da conta e seu saldo e métodos
* para realizar as operações de depósito e saque.
* Escrever um programa para testar a classe. */

class ContaBancaria {
    public String nome;
    public String numeroConta;
    public double saldo = 0;

    public void deposito(double valorDepositado) {
        this.saldo += valorDepositado;
    }

    public void saque(double valorSacado) {
        this.saldo -= valorSacado;
    }
}

public class Q3 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        conta.nome = "Maxwell Dantas";
        conta.numeroConta = "12345-67";
        System.out.println("Nome da conta: " + conta.nome);
        System.out.println("Número da conta: " + conta.numeroConta);
        System.out.println("Saldo: R$ " + conta.saldo);
        conta.deposito(500);
        System.out.println("Saldo após depósito de R$ 500,00: R$ " + conta.saldo);
        conta.saque(500.75);
        System.out.println("Saldo após saque de R$ 500,75: R$ " + conta.saldo);
    }
}