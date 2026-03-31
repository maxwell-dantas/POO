package Lista03;

/* Escrever uma classe para resolver uma Equação do 2o grau.
* • A classe deve calcular o delta e as raízes de uma equação do segundo grau, com base nos coeficientes a, b e c
* de uma equação f(x) = ax² + bx + c
* • O construtor da classe recebe os valores iniciais dos atributos. Os métodos de acesso podem alterar e recuperar
* esses valores;
* • O método Delta retorna o valor do delta usado no cálculo das raízes;
* • O método TemRaizesReais retorna um booleano informando se a equação tem ou não raízes reais;
* • O método Raiz1 retorna a primeira raiz real, se houver;
* • O método Raiz2 retorna a segunda raiz real, se houver;
* • O método ToString deve retornar um texto com os atributos do objeto. */

import java.util.Scanner;

class Equacao {
    private int a;
    private int b;
    private int c;

    public Equacao(int a, int b, int c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    public void setA(int a) {
        if (a != 0) {
            this.a = a;
        } else throw new IllegalArgumentException("O valor de A deve ser diferente de zero!");
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int delta() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public boolean temRaizesReais() {
        return (this.delta() >= 0);
    }

    public double raiz1() {
        if (temRaizesReais()) {
            return (- this.b + Math.sqrt(this.delta())) / (2.0 * this.a);
        } else return Double.NaN;
    }

    public double raiz2() {
        if (temRaizesReais()) {
            return (- this.b - Math.sqrt(this.delta())) / (2.0 * this.a);
        } else return Double.NaN;
    }

    @Override
    public String toString() {
        int delta = this.delta();
        String signalA = (this.a >= 0) ? "" : "-";
        String signalB = (this.b >= 0) ? "+ " : "-";
        String signalC = (this.c >= 0) ? "+ " : "- ";
        String fraseBase = "A equação f(x) " + signalA + Math.abs(this.a) + "x² " + signalB + Math.abs(this.b)
                + "x " + signalC + Math.abs(this.c) + " tem como delta o valor: " + delta + " e ";
        if (this.temRaizesReais()) {
            String r1 = String.format("x' = %.2f", this.raiz1());
            String r2 = String.format("x'' = %.2f", this.raiz2());
            return fraseBase + "possui raízes reais\n" + r1 + " | " + r2;
        } else return fraseBase + "não possui raízes reais!";
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o coeficiente A pertencente aos números inteiros: ");
        int a = leitor.nextInt();
        System.out.print("Insira o coeficiente B pertencente aos números inteiros: ");
        int b = leitor.nextInt();
        System.out.print("Insira o coeficiente C pertencente aos números inteiros: ");
        int c = leitor.nextInt();
        leitor.close();

        Equacao eq1 = new Equacao(a, b, c);
        System.out.println(eq1);
    }
}