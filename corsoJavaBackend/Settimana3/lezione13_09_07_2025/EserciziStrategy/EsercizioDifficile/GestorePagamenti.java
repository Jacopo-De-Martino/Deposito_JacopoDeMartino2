package corsoJavaBackend.lezione13_09_07_2025.EserciziStrategy.EsercizioDifficile;

public class GestorePagamenti {
    public static void main(String[] args) {
        PagamentoContext pagamentoContext = PagamentoContext.getPagamentoContext();
        pagamentoContext.setMetodoPagamento(new CartaDiCredito());
        pagamentoContext.setTipoPagamento(new BonificoIstantaneo());

        User user1 = new User();
        user1.setNome("Pippo");
        pagamentoContext.registraOsservatore(user1);
        User user2 = new User();
        user2.setNome("Luca");
        pagamentoContext.registraOsservatore(user2);
        pagamentoContext.paga(20, "PD");
    }
}
