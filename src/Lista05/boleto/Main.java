package Lista05.boleto;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTES DO BOLETO ===\n");

        // ---------------------------------------------------------
        System.out.println("Teste 1: O boleto deve iniciar em aberto");
        Boleto boleto1 = new Boleto("111", LocalDateTime.now(), LocalDate.of(2026, 4, 24), 500.0);
        System.out.println("Esperado: EM_ABERTO | Real: " + boleto1.Situacao());
        System.out.println("---------------------------------------------------------\n");

        // ---------------------------------------------------------
        System.out.println("Teste 2: Pagamento exato não deve gerar troco");
        boleto1.Pagar(500.0);
        System.out.println("Esperado: PAGO | Real: " + boleto1.Situacao());
        System.out.println("Troco esperado: 0.0 | Troco real: " + boleto1.getTroco());
        System.out.println("---------------------------------------------------------\n");

        // ---------------------------------------------------------
        System.out.println("Teste 3: Tentar pagar um boleto já pago deve dar erro");
        try {
            boleto1.Pagar(50.0);
            System.out.println("⚠️ FALHA: O sistema deixou pagar de novo!");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ SUCESSO: O sistema bloqueou. Motivo: " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------\n");

        // ---------------------------------------------------------
        System.out.println("Teste 4: Pagamento com valor maior deve gerar troco");
        Boleto boleto2 = new Boleto("222", LocalDateTime.now(), LocalDate.of(2026, 4, 24), 500.0);
        boleto2.Pagar(600.0);
        System.out.println("Esperado: PAGO | Real: " + boleto2.Situacao());
        System.out.println("Troco esperado: 100.0 | Troco real: " + boleto2.getTroco());
        System.out.println("---------------------------------------------------------\n");

        // ---------------------------------------------------------
        System.out.println("Teste 5: Pagamento parcelado até quitar e sobrar troco");
        Boleto boleto3 = new Boleto("333", LocalDateTime.now(), LocalDate.of(2026, 4, 24), 500.0);

        boleto3.Pagar(300.0);
        System.out.println("Após 1º pagamento (R$ 300) -> Esperado: PAGO_PARCIAL | Real: " + boleto3.Situacao());

        boleto3.Pagar(300.0); // Total pago vai para 600
        System.out.println("Após 2º pagamento (R$ 300) -> Esperado: PAGO | Real: " + boleto3.Situacao());
        System.out.println("Troco esperado: 100.0 | Troco real: " + boleto3.getTroco());
        System.out.println("---------------------------------------------------------\n");

        // ---------------------------------------------------------
        System.out.println("Teste 6: Tentar pagar com valor zero ou negativo deve dar erro");
        Boleto boleto4 = new Boleto("444", LocalDateTime.now(), LocalDate.of(2026, 4, 24), 500.0);
        try {
            boleto4.Pagar(0.0);
            System.out.println("⚠️ FALHA: O sistema aceitou um pagamento de R$ 0.0!");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ SUCESSO: O sistema bloqueou. Motivo: " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------\n");
    }
}