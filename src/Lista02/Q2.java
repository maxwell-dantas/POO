package Lista02;
import java.util.Scanner;

/* Escrever a classe Viagem. A classe deve ter atributos para
* armazenar a distância em km e o tempo gasto em horas e minutos da viagem realizada. A classe deve possuir
* método para calcular a velocidade média atingida na viagem em km/h de acordo com a distância e o tempo gasto,
* além dos métodos de acesso para definir e recuperar os atributos.
* Escrever um programa para testar a classe. */

class Viagem {
    private double distancia;
    private int horas;
    private int minutos;

    public Viagem(double distancia, int horas, int minutos) {
        this.setDistancia(distancia);
        this.setHoras(horas);
        this.setMinutos(minutos);
    }

    public void setDistancia(double distancia){
        if (distancia > 0) {
            this.distancia = distancia;
        } else throw new IllegalArgumentException("Insira um valor válido para a distância!");
    }

    public void setHoras(int horas){
        if (horas >= 0) {
            this.horas = horas;
        } else throw new IllegalArgumentException("Insira um valor válido para as horas!");
    }

    public void setMinutos(int minutos){
        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        } else throw new IllegalArgumentException("Insira um valor entre 0 e 59 para os minutos!");
    }

    public double getDistancia() {
        return this.distancia;
    }

    public int getHoras() {
        return this.horas;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public double calculaVelocidadeMedia() {
        double minutosCorrigidos = this.minutos / 60.0;
        double tempoTotal = this.horas + minutosCorrigidos;

        if (tempoTotal > 0) {
            return this.distancia / tempoTotal;
        } else throw new IllegalArgumentException("Digite um tempo válido!");
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite a sua distância percorrida: ");
        double distancia = leitura.nextDouble();
        System.out.print("Informe quantas horas durou a viagem: ");
        int horas = leitura.nextInt();
        System.out.print("Informe quantos minutos durou a viagem: ");
        int minutos = leitura.nextInt();
        leitura.close();

        Viagem viagem = new Viagem(distancia, horas, minutos);
        System.out.printf("\n A velocidade média da sua viagem foi de %.2f km/h\n", viagem.calculaVelocidadeMedia());
    }
}