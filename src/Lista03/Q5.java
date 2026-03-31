package Lista03;
import java.util.Scanner;

class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.setData(String.format("%d/%d/%d", dia, mes, ano));
    }

    public int getAno() {
        return this.ano;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setData(String data) {
        String[] dataSeparada = data.split("/");
        int dia = Integer.parseInt(dataSeparada[0]);
        int mes = Integer.parseInt(dataSeparada[1]);
        int ano = Integer.parseInt(dataSeparada[2]);

        int divisaoInteiraMes = mes / 8;
        int mes_corrigido = divisaoInteiraMes + mes;

        boolean bissexto = ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;

        int maxDia = 30;
        if (mes_corrigido % 2 != 0 && mes != 2) {
            maxDia = 31;
        }

        if (mes == 2) {
            if (bissexto) {
                maxDia = 29;
            } else {
                maxDia = 28;
            }
        }

        if (dia >= 1 && dia <= maxDia && mes >= 1 && mes <= 12 && ano != 0) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else throw new IllegalArgumentException("Insira uma data válida!");
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("----- DATA -----");
        System.out.print("Dia: ");
        int dia = leitor.nextInt();

        System.out.print("Mês: ");
        int mes = leitor.nextInt();

        System.out.print("Ano: ");
        int ano = leitor.nextInt();

        leitor.close();

        Data data1 = new Data(dia, mes, ano);
        System.out.println(data1);
    }
}