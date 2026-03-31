package Lista03;

/* Escrever a classe Conversor.
* • A classe deve permitir a conversão de um valor decimal inteiro e positivo,
* armazenado no atributo num, para o formato binário;
* • O construtor da classe recebe o valor inicial do número na base dez;
* • Os métodos de acesso podem alterar e recuperar esse valor;
* • O método Binario deve realizar a conversão do número decimal e retornar a sua
* representação em binário;
* • O método ToString deve retornar um texto com o número nas bases decimal e
* binária. */

import java.util.Scanner;

class Conversor {
    private int numeroDecimal;

    public Conversor(int numeroDecimal) {
        this.setNumeroDecimal(numeroDecimal);
    }

    public void setNumeroDecimal(int numeroDecimal) {
        if (numeroDecimal >= 0) {
            this.numeroDecimal = numeroDecimal;
        } else throw new IllegalArgumentException("O valor do número precisa ser positivo!");
    }

    public int getNumeroDecimal() {
        return this.numeroDecimal;
    }

    public String binario() {
        if (this.numeroDecimal == 0) return "0";

        String decimalToBinario = "";
        int tempNumero = this.numeroDecimal;

        while (tempNumero > 0) {
            int resto = tempNumero % 2;
            tempNumero /= 2;
            String intToString = String.valueOf(resto);
            decimalToBinario = intToString + decimalToBinario;
        }
        return decimalToBinario;
    }

    public String toString() {
        return "\nNúmero decimal: " + this.numeroDecimal + "\nNúmero em binário: " + this.binario();
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o número na base 10: ");
        int numeroDecimal = leitor.nextInt();
        leitor.close();

        Conversor binario = new Conversor(numeroDecimal);
        System.out.println(binario);
    }
}