package revisao;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/* Escrever a classe Bingo, utilizada para realizar um jogo de bingo.
* • Os atributos numBolas e bolas representam o número de bolas do bingo e as bolas de uma partida;
* • O método construtor inicia uma partida, definindo o número de bolas do jogo;
* • O método Próximo sorteia uma bola, retornando o seu número (deve ser um valor entre um e o número de bolas
* ou menos um, caso todas as bolas já tenham sido sorteadas);
* • O método Sorteados retorna uma lista com todas as bolas já sorteadas;
* • Insira outros atributos e métodos nas classes, caso necessário.
* Faça um programa para testar a classe Bingo. */

class Bingo {
    private int numBolas; // número de bolas por rodada
    private int[] bolas; // lista de bolas
    private ArrayList<Integer> listaSorteada = new ArrayList<>(); // lista de bolas sorteadas na sequência

    public Bingo(int numBolas) {
        this.setNumBolas(numBolas);
        this.setLista();
    }

    // valida a quantidade de bolas na rodada
    public void setNumBolas(int numBolas) {
        if (numBolas > 0) this.numBolas = numBolas;
        else throw new IllegalArgumentException("Insira um número de bolas válido para esta rodada!");
    }

    // define uma lista das bolas do bingo
    private void setLista() {
        int[] listaBolas = new int[this.numBolas];
        for (int i = 0; i < this.numBolas; i++) {
            listaBolas[i] = i + 1;
        }
        this.bolas = listaBolas;
    }

    // retorna a lista das bolas do bingo
    public String getBolas() {
        return Arrays.toString(this.bolas);
    }

    // executa o sorteio do número
    public int proximo() {
        if (this.listaSorteada.size() == this.numBolas) {
            return -1;
        }
        else {
            Random random = new Random();
            int numeroSorteado = random.nextInt(this.numBolas) + 1;
            boolean verificador = this.verificador(numeroSorteado);

            while (!verificador) {
                numeroSorteado = random.nextInt(this.numBolas) + 1;
                verificador = this.verificador(numeroSorteado);
            }
            this.listaSorteada.add(numeroSorteado);
            return numeroSorteado;
        }
    }

    // valida o número sorteado
    private boolean verificador(int numeroSorteado) {
        boolean verificador = true;
        for (int i = 0; i < this.listaSorteada.size(); i++) {
            if (numeroSorteado == this.listaSorteada.get(i)) {
                verificador = false;
                break;
            }
        }
        return verificador;
    }

    // retorna a lista dos números sorteados em ordem
    public ArrayList<Integer> getListaSorteada() {
        return this.listaSorteada;
    }
}

public class Q1bingo {
    public static void main(String[] args) {
        Bingo jogo1 = new Bingo(5);
        System.out.println(jogo1.getBolas());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.proximo());
        System.out.println(jogo1.getBolas());
        System.out.println(jogo1.getListaSorteada());
    }
}