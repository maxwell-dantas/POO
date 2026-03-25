class Viagem {
    public double km = 0;
    public int horas = 0;
    public int minutos = 0;

    public double velocidadeMedia() {
        double minutosParaHora = this.minutos / 60.0;
        double horasCorrigidas = minutosParaHora + this.horas;
        return this.km / horasCorrigidas;
    }
}


public class viagemExercicio {
    public static void main(String[] args) {
        Viagem x = new Viagem();
        x.km = 500;
        x.horas = 20;
        x.minutos = 20;
        System.out.println(x.velocidadeMedia());
    }
}