package Lista02;
import java.util.Scanner;

/* Escrever uma classe para modelar uma conta bancária com todos os atributos encapsulados. A classe deve ter
* atributos para armazenar o nome do titular da conta, o número da conta e seu saldo e métodos para realizar as
* operações de depósito e saque, além dos métodos de acesso para definir e recuperar os atributos.
* Escrever um programa para testar a classe e elaborar seu digrama UML. */

class ContaBancaria {
    private String nomeTitular;
    private String numeroConta;
    private double saldo = 0.0;

    public ContaBancaria(String nomeTitular, String numeroConta) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
    }


    public double getSaldo() {
        return this.saldo;
    }

    public void deposito(double valorDeposito) {
        if (valorDeposito >= 0){
            this.saldo += valorDeposito;
        } else throw new IllegalArgumentException("O valor do depósito não pode ser negativo!");
    }

    public void saque(double valorSaque) {
        if (valorSaque < 0) {
            throw new IllegalArgumentException("O valor do saque não pode ser negativo!");
        } else if (valorSaque <= this.saldo) {
            this.saldo -= valorSaque;
        } else throw new IllegalArgumentException("Saldo insuficiente!");
    }

    public String toString() {
        return "--------------------\nNome do titular da conta: " + this.nomeTitular + "\nNúmero da conta: "
        + this.numeroConta + "\nSaldo atual da conta: R$" + this.saldo + "\n--------------------";
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o nome do titular da conta: ");
        String nomeTitular = leitor.nextLine();

        System.out.print("Insira o número da conta: ");
        String numeroConta = leitor.nextLine();

        ContaBancaria conta01 = new ContaBancaria(nomeTitular, numeroConta);
        System.out.println(conta01);

        conta01.deposito(500);
        System.out.printf("Saldo atual após depósito de R$500,00: R$%.2f\n", conta01.getSaldo());

        conta01.saque(300);
        System.out.printf("Saldo atual após saque de R$300,00: R$%.2f\n", conta01.getSaldo());

        conta01.saque(1000);
    }
}