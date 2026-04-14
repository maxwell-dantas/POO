package Lista05;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Paciente {
    private String nome;
    private Cpf cpf;
    private String telefone;
    private LocalDate nascimento;

    public Paciente(String nome, Cpf cpf, String telefone, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        setNascimento(nascimento);
    }

    public void setNascimento(LocalDate nascimento) {
        if (nascimento.getYear() <= LocalDate.now().getYear()) {
            this.nascimento = nascimento;
        } else throw new IllegalArgumentException("Insira uma data válida!");
    }

    public String getNascimentoFormatado() {
        if (nascimento == null) {return "Data não cadastrada!";}
        DateTimeFormatter padraoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.nascimento.format(padraoBR);
    }

    public String idade() {
        Period periodo = Period.between(nascimento, LocalDate.now());
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        return anos + " anos e " + meses + " meses";
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf.getCpfFormatado() + "\nTelefone: "
                + telefone + "\nData de nascimento: " + getNascimentoFormatado();
    }

}

class Cpf {
    private String cpf;
    public Cpf(String cpf) {
        setCpf(cpf);
    }

    public void setCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // remove qualquer coisa que não seja número
        if (cpf.length() != 11) {throw new IllegalArgumentException("Insira um CPF Válido! Tamanho incorreto.");}
        long cpfSemDigitoVerificador = Long.parseLong(cpf) / 100;

        // PRIMEIRO DÍGITO
        int multiplicador = 2;
        int acumulador = 0;
        for (int i = 0; i < 9; i++) {
            long restoNum = cpfSemDigitoVerificador % 10;
            cpfSemDigitoVerificador /= 10;
            acumulador += multiplicador * restoNum;
            multiplicador += 1;
        }

        int restoAcumulador = acumulador % 11;
        char digito1 = (restoAcumulador < 2) ? '0' : (char) ((11 - restoAcumulador) + '0');
        if (digito1 != cpf.charAt(9)) {throw new IllegalArgumentException("Insira um CPF Válido!");}

        String cpfPrimeiroDigitoString = cpf.substring(0, 9) + digito1;
        long cpfPrimeiroDigito = Long.parseLong(cpfPrimeiroDigitoString);

        // SEGUNDO DÍGITO
        multiplicador = 2;
        acumulador = 0;
        for (int i = 0; i < 10; i++) {
            long restoNum = cpfPrimeiroDigito % 10;
            cpfPrimeiroDigito /= 10;
            acumulador += multiplicador * restoNum;
            multiplicador += 1;
        }
        restoAcumulador = acumulador % 11;
        char digito2 = (restoAcumulador < 2) ? '0' : (char) ((11 - restoAcumulador) + '0');
        if (digito2 != cpf.charAt(10)) {throw new IllegalArgumentException("Insira um CPF Válido!");}
        this.cpf = cpf;
    }

    public String getCpf() {return cpf;}
    public String getCpfFormatado(){
        if (cpf == null) {return null;}
        StringBuilder formatador = new StringBuilder(cpf);
        formatador.insert(3, ".");
        formatador.insert(7, ".");
        formatador.insert(11, "-");
        return formatador.toString();
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("CPF: ");
        String cpf = leitor.nextLine();
        System.out.print("Telefone: ");
        String telefone = leitor.nextLine();
        System.out.println("Data de nascimento:");
        System.out.print("Dia: ");
        int dia = leitor.nextInt();
        System.out.print("Mês: ");
        int mes = leitor.nextInt();
        System.out.print("Ano: ");
        int ano = leitor.nextInt();
        LocalDate nascimento = LocalDate.of(ano, mes, dia);

        Cpf cpfPaciente = new Cpf(cpf);
        Paciente paciente = new Paciente(nome, cpfPaciente, telefone, nascimento);
        System.out.println(paciente);
        System.out.println(paciente.idade());

    }
}
