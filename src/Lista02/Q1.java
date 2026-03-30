package Lista02;
import java.util.Scanner;

/* Escrever a classe Círculo. A classe deve ter um atributo raio
* para armazenar a dimensão da figura e métodos para calcular sua área e sua circunferência, além dos métodos de
* acesso para definir e recuperar o atributo raio.
* Escrever um programa para testar a classe. */

class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.setRaio(raio);
    }

    public void setRaio(double raio) {
        if (raio > 0) {
            this.raio = raio;
        } else throw new IllegalArgumentException("Insira um valor positivo não-nulo para o raio!");
    }

    public double getRaio() {
        return this.raio;
    }

    public double calculaArea() {
        return Math.PI * (this.raio * this.raio);
    }

    public double calculaCircunferencia() {
        return 2 * Math.PI * this.raio;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe o valor do raio: ");
        double raio = leitura.nextDouble();
        leitura.close();

        Circulo circulo = new Circulo(raio);
        System.out.printf("Raio: %.2f | Área: %.2f | Circunferência: %.2f\n", circulo.getRaio(), circulo.calculaArea(),
                circulo.calculaCircunferencia());
    }
}