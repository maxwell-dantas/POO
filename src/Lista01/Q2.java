package Lista01;

/* A classe deve ter atributos para armazenar a distância em km e o tempo gasto em horas e minutos da viagem
* realizada. A classe deve possuir método para calcular a velocidade média atingida na viagem em km/h de acordo
* com a distância e o tempo gasto.
* Escrever um programa para testar a classe. */

class Viagem {
    public double distancia;
    public int horas;
    public int minutos;

    public double calcVelocidadeMedia() {
        double corrigeMinutos = this.minutos / 60.0;
        double horasTotais = this.horas + corrigeMinutos;
        return this.distancia / horasTotais;
    }
}


public class Q2 {
    public static void main(String[] args) {
        Viagem viagem = new Viagem();
        viagem.distancia = 1500.5;
        viagem.horas = 1200;
        viagem.minutos = 77;
        System.out.println("Distância da viagem: " + viagem.distancia);
        System.out.println("Tempo de duração da viagem (hh/mm): " + viagem.horas + ":" + viagem.minutos);
        System.out.printf("A velocidade média percorrida na viagem foi de %.2f km/h\n", viagem.calcVelocidadeMedia());
    }
}