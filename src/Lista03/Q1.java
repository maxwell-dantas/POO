package Lista03;
import java.util.Scanner;

/* Escrever a classe Retangulo.
 * • A classe deve ter como atributos: a base (b) e a altura (h) do retângulo;
 * • O construtor da classe recebe os valores iniciais da base e altura do
 * retângulo, que devem ser positivos;
 * • Os métodos SetBase e SetAltura podem modificar os valores da base e da
 * altura, respectivamente;
 * • Os métodos GetBase e GetAltura retornam os valores armazenados nos
 * atributos;
 * • CalcArea e CalcDiagonal calculam a área e a diagonal do retângulo;
 * • O método ToString deve retornar um texto com os atributos do objeto. */

class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.setBase(base);
        this.setAltura(altura);
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else throw new IllegalArgumentException("Insira o valor de uma base válida!");
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else throw new IllegalArgumentException("Insira o valor de uma altura válida!");
    }

    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public double calcArea() {
        return this.base * this.altura;
    }

    public double calcDiagonal() {
        return Math.hypot(this.base, this.altura);
    }

    @Override // Serve para informar que estou sobrescrevendo um método padrão do Java
    public String toString() {
        return "Base do retângulo: " + this.base + "\nAltura do retângulo: " + this.altura + "\nÁrea do retângulo: "
                + this.calcArea() + "\nDiagonal do retângulo: " + this.calcDiagonal();
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira a base do retângulo: ");
        double baseRetangulo = leitor.nextDouble();
        System.out.print("Insira a altura do retângulo: ");
        double alturaRetangulo = leitor.nextDouble();
        leitor.close();

        Retangulo retangulo1 = new Retangulo(baseRetangulo, alturaRetangulo);
        System.out.println(retangulo1);
    }
}