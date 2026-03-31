package Lista03;
import java.util.Scanner;

/* Escrever a classe Frete.
* • A classe deve utilizar os atributos distância e peso para calcular o frete cobrado
* por uma transportadora para transportar uma carga de uma origem até um
* destino;
* • O construtor da classe recebe os valores iniciais da distância e do peso, que
* devem ser positivos;
* • Os métodos de acesso podem alterar e recuperar esses valores;
* • O peso (massa) da carga é dado em Kg e a distância percorrida até o destino
* em Km;
* • O valor do frete calculado pelo método CalcFrete deve ser de um centavo de
* real para cada quilo transportado por quilometro;
* • O método ToString deve retornar um texto com os atributos do objeto. */

class Frete {
    private double distancia;
    private double peso;

    public Frete(double distancia, double peso) {
        this.setDistancia(distancia);
        this.setPeso(peso);
    }

    public void setDistancia(double distancia) {
        if (distancia > 0) {
            this.distancia = distancia;
        } else throw new IllegalArgumentException("O valor da distância não pode ser negativo!");
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        } else throw new IllegalArgumentException("O valor do peso não pode ser negativo!");
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getPeso() {
        return this.peso;
    }

    public double calcFrete() {
        return this.distancia * this.peso * 0.01;
    }

    @Override
    public String toString() {
        return "----- INFORMAÇÕES DO FRETE -----\nPeso do produto (em Kg): " + this.peso + "\nValor por Kg: R$ 0.01\n" +
                "Distância (em Km): " + this.distancia + "\nValor total: R$" + this.calcFrete() + "\n--------------------------------\n";
    }

}

public class Q2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o peso do produto (em Kg): ");
        double peso = leitor.nextDouble();
        System.out.print("Insira a distância a ser percorrida até o destino (em Km): ");
        double distancia = leitor.nextDouble();
        leitor.close();

        Frete produto1 = new Frete(distancia, peso);
        System.out.println(produto1);
    }
}