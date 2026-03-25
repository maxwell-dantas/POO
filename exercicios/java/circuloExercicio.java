class Circulo {
    public double raio = 0;
    public double pi = 3.14;

    public double pegaArea() {
        double raioQuadrado = this.raio * this.raio;
        return this.pi * raioQuadrado;
    }

    public double pegaCircunferencia() {
        return this.pi * this.raio * 2;
    }
}

class circuloExercicio {
    public static void main (String[] args) {
        Circulo x = new Circulo();
        x.raio = 5;
        System.out.println(x.pegaArea());
        System.out.println(x.pegaCircunferencia());
    }
}