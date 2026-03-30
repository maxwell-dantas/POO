package Lista01;

/* A classe deve ter um atributo raio para armazenar a dimensão da figura e métodos para calcular sua área e sua
* circunferência.
* Escrever um programa para testar a classe. */

class Circulo {
    public double raio;
    public double pi = 3.14159;

    public double calcArea() {
        return this.pi * (this.raio * this.raio);
    }

    public double calcCircunferencia() {
        return 2 * this.pi * this.raio;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Circulo x = new Circulo();
        x.raio = 5;
        System.out.printf("Raio: %.2f | Área: %.2f | Circunferência: %.2f\n", x.raio, x.calcArea(), x.calcCircunferencia());
    }
}