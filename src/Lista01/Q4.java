package Lista01;

/* A classe deve ter atributos para armazenar o dia e o horário de uma sessão de cinema e métodos para calcular o
* valor da entrada inteira e da meia-entrada.
* O valor das entradas deve ser calculado com base nas seguintes regras:
* • Segunda, terça e quinta, o valor base do ingresso é R$ 16,00.
* • Nas quartas todos pagam meia-entrada no valor de R$ 8,00, em qualquer horário.
* • Sexta, sábado e domingo, o valor base do ingresso é R$ 20,00.
* • Das 17h à meia-noite, há acréscimo de 50% no valor base do ingresso.
* Escrever um programa para testar a classe. */

class Cinema {
    public String diaSemana;
    public byte horario;
    private double ingresso;

    public Cinema(String diaSemana, int horario) {
        this.diaSemana = diaSemana;
        this.horario = (byte) horario;
    }

    public double calculaValorInteira() {
        String[] arrayDiasSemana = {"segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domingo"};
        if (this.diaSemana.equals(arrayDiasSemana[2])){
            this.ingresso = 8.0;
        } else if (this.diaSemana.equals(arrayDiasSemana[0]) || this.diaSemana.equals(arrayDiasSemana[1]) || this.diaSemana.equals(arrayDiasSemana[3])) {
            this.ingresso = 16.0;
        } else {
            this.ingresso = 20.0;
        }

        if (this.horario >= 17 && this.horario <= 24 && !this.diaSemana.equals(arrayDiasSemana[2])) {
            this.ingresso *= 1.5;
        }
        return this.ingresso;
    }

    public double calculaValorMeia() {
        if (this.diaSemana.equals("quarta")) {
            return 8.0;
        } else {
            return this.calculaValorInteira() / 2;
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        // Teste 1: Terça-feira, 15h (Base R$ 16, sem acréscimo)
        Cinema filme1 = new Cinema("terça", 15);
        System.out.println("Terça 15h - Inteira: R$ " + filme1.calculaValorInteira()); // R$ 16.0
        System.out.println("Terça 15h - Meia: R$ " + filme1.calculaValorMeia());       // R$ 8.0

        // Teste 2: Sexta-feira, 20h (Base R$ 20 + 50% acréscimo)
        Cinema filme2 = new Cinema("sexta", 20);
        System.out.println("\nSexta 20h - Inteira: R$ " + filme2.calculaValorInteira()); // R$ 30.0
        System.out.println("Sexta 20h - Meia: R$ " + filme2.calculaValorMeia());       // R$ 15.0

        // Teste 3: Quarta-feira, 22h (Sempre R$ 8 para todos, ignorando acréscimo)
        Cinema filme3 = new Cinema("quarta", 22);
        System.out.println("\nQuarta 22h - Inteira: R$ " + filme3.calculaValorInteira()); // R$ 8.0
        System.out.println("Quarta 22h - Meia: R$ " + filme3.calculaValorMeia());       // R$ 8.0
    }
}
